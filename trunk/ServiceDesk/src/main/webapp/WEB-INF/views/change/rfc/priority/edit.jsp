<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="fieldgroup.change.rfc.priority.all">
    <form:form modelAttribute="rfcPriority" method="post">
        <ui:errorList/>
        <ui:propertyList>
            <ui:propertyItem code="field.change.rfc.priority.id">
                ${rfcPriority.id}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.priority.name" label="name">
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.priority.urgent" label="urgent">
                <form:checkbox path="urgent" />
                <form:errors path="urgent" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.priority.order" label="order">
                <form:input path="order" />
                <form:errors path="order" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>