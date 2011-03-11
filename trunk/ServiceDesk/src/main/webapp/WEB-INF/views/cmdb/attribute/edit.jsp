<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="fieldgroup.cmdb.entity.class.simple">
    <form:form modelAttribute="attribute" method="post">
        <ui:errorList/>
        <ui:propertyList>
            <ui:propertyItem code="field.cmdb.class.attribute.name" label="name">
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.class.attribute.description" label="description">
                <form:textarea path="description" rows="4" cols="60" />
                <form:errors path="description" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.class.attribute.displayNo" label="displayNo">
                <form:input path="displayNo" />
                <form:errors path="displayNo" cssClass="error" />
            </ui:propertyItem>

             <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
