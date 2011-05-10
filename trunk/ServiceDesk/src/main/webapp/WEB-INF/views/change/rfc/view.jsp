<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="change" tagdir="/WEB-INF/tags/ui/change" %>

<ui:panel caption="fieldgroup.change.rfc.basic">
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.id">
            ${rfc.id}
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.title">
            ${rfc.title}
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.description">
            ${rfc.description}
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.priority">
             <print:nullable object="${rfc.priority}">
                 ${rfc.priority.name}
             </print:nullable>
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.impact">
            <print:nullable object="${rfc.impact}">
                 ${rfc.impact.name}
            </print:nullable>
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.state">
            ${rfc.state.name}
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.creator">
            <link:employee object="${rfc.creator}" />
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.creationTime">
             <print:datetime datetime="${rfc.timestamp}" />
        </ui:propertyItem>
    </ui:propertyList>
    <ui:propertyList>
         <ui:propertyItem code="field.change.rfc.manager">
             <link:employee object="${rfc.manager}" />
        </ui:propertyItem>
    </ui:propertyList>
</ui:panel>

<ui:panel caption="fieldgroup.change.rfc.history">
    <c:forEach items="${history}" var="entry">
        <spring:eval expression="entry instanceof T(servicedesk.change.domain.RfcComment)" var="isComment" />
        <c:choose>
            <c:when test="${isComment}"> 
                <change:rfcComment comment="${entry}" />
            </c:when>
            <c:otherwise>
                <change:rfcChange change="${entry}" />
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ui:panel>

<ui:panel caption="fieldgroup.change.rfc.comments">
    <c:forEach items="${rfc.comments}" var="comment">
        
    </c:forEach>
</ui:panel>