package sd.em.ws;

import java.text.SimpleDateFormat;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

import sd.em.domain.Event;
import sd.em.domain.EventCategory;
import sd.em.domain.EventParameter;
import sd.em.domain.EventSignificance;
import sd.em.editor.EventCategoryEditor;
import sd.em.editor.EventSignificanceEditor;
import sd.em.service.EventService;

@Component
public class EndPoint extends AbstractJDomPayloadEndpoint {

    /**
     * Namespace of both request and response.
     */
    public static final String NAMESPACE_URI = "sd.em.logging";
    /**
     * The local name of the expected request.
     */
    public static final String ECHO_REQUEST_LOCAL_NAME = "eventsRequest";
    /**
     * The local name of the created response.
     */
    public static final String ECHO_RESPONSE_LOCAL_NAME = "eventsResponse";
    @Autowired(required = true)
    private EventService eventService;
    @Autowired(required = true)
    private EventSignificanceEditor eventSignificanceEditor;
    @Autowired(required = true)
    private EventCategoryEditor eventCategoryEditor;

    public void setEventSignificanceEditor(EventSignificanceEditor eventSignificanceEditor) {
        this.eventSignificanceEditor = eventSignificanceEditor;
    }

    public void setEventCategoryEditor(EventCategoryEditor eventCategoryEditor) {
        this.eventCategoryEditor = eventCategoryEditor;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    private XPath eventsExpression;
    private XPath eventDateExpression;
    private XPath subjectExpression;
    private XPath typeExpression;
    private XPath categoryExpression;
    private XPath parametersExpression;
    private XPath parameterNameExpression;
    private XPath parameterValueExpression;
    private XPath incidentExpression;

    public EndPoint() throws JDOMException {
        Namespace namespace = Namespace.getNamespace("sd", NAMESPACE_URI);
        eventsExpression = XPath.newInstance("//sd:event");
        eventsExpression.addNamespace(namespace);
        eventDateExpression = XPath.newInstance(".//sd:date");
        eventDateExpression.addNamespace(namespace);
        subjectExpression = XPath.newInstance(".//sd:subject");
        subjectExpression.addNamespace(namespace);
        typeExpression = XPath.newInstance(".//sd:significance");
        typeExpression.addNamespace(namespace);
        categoryExpression = XPath.newInstance(".//sd:category");
        categoryExpression.addNamespace(namespace);
        incidentExpression = XPath.newInstance(".//sd:incident");
        incidentExpression.addNamespace(namespace);
        parametersExpression = XPath.newInstance(".//sd:parameter");
        parametersExpression.addNamespace(namespace);
        parameterNameExpression = XPath.newInstance("sd:name");
        parameterNameExpression.addNamespace(namespace);
        parameterValueExpression = XPath.newInstance("sd:value");
        parameterValueExpression.addNamespace(namespace);
    }

    /**
     * Reads the given <code>requestElement</code>, and sends a the response back.
     *
     * @param requestElement the contents of the SOAP message as DOM elements
     * @param document       a DOM document to be used for constructing <code>Node</code>s
     * @return the response element
     */
    protected Element invokeInternal(Element requestElement) throws Exception {
        Assert.isTrue(NAMESPACE_URI.equals(requestElement.getNamespaceURI()), "Invalid namespace");
        Assert.isTrue(ECHO_REQUEST_LOCAL_NAME.equals(requestElement.getName()), "Invalid local name");
        Assert.notNull(eventService, "eventService assert not null");
        Assert.notNull(eventSignificanceEditor, "eventSignificanceEditor assert");
        Assert.notNull(eventCategoryEditor, "eventCategoryEditor assert");

        boolean participate = false;
        if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
            participate = true;
        } else {
            Session session = sessionFactory.openSession();
            session.setFlushMode(FlushMode.COMMIT);
            TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Object element : eventsExpression.selectNodes(requestElement)) {
            Element eventElement = (Element) element;
            logger.info("invokeInternal() eventElement: " + eventElement.getValue());
            Event event = new Event();
            event.setEventDate(dateFormat.parse(eventDateExpression.valueOf(eventElement)));
            event.setSubject(subjectExpression.valueOf(eventElement));
            eventSignificanceEditor.setAsText(typeExpression.valueOf(eventElement));
            event.setSignificance((EventSignificance) eventSignificanceEditor.getValue());
            eventCategoryEditor.setAsText(categoryExpression.valueOf(eventElement));
            event.setCategory((EventCategory) eventCategoryEditor.getValue());
            boolean incident = Boolean.parseBoolean(incidentExpression.valueOf(eventElement));
            for (Object o : parametersExpression.selectNodes(eventElement)) {
                EventParameter parameter = new EventParameter();
                Element e = (Element) o;
                parameter.setName(parameterNameExpression.valueOf(e));
                parameter.setValue(parameterValueExpression.valueOf(e));
                logger.info("invokeInternal() parameter: " + parameter);
                event.addParameter(parameter);
            }
            logger.info("invokeInternal() event: " + event + " incident: " + incident);
            eventService.add(event, incident);
        }

        Element responseElement = new Element(ECHO_RESPONSE_LOCAL_NAME, "sd", NAMESPACE_URI);
        responseElement.addContent("OK");

        if (!participate) {
            SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
            Session session = sessionHolder.getSession();
            session.flush();
            session.close();
        }

        return responseElement;
    }
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
