<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="fieldgroup.cmdb.relationship.class.simple">
    <form:form modelAttribute="relationshipClass" method="post">
        <ui:errorList fieldPrefix="field.cmdb.entity.class"/>
        <ui:propertyList>
            <ui:propertyItem code="field.cmdb.entity.class.name" label="name">
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.entity.class.abstraction" label="description">
                <form:checkbox path="abstraction" />
                <form:errors path="abstraction" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.entity.class.parent" label="description">
                <sd:treePicker name="parent" value="${relationshipClass.parent}" source="cmdbRelationshipClassTree"/>
                <form:errors path="parent" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.relationship.class.sourceItemClass" label="sourceItemClass">
                <sd:treePicker name="sourceItemClass" value="${relationshipClass.sourceItemClass}" source="cmdbItemClassTree"/>
                <form:errors path="sourceItemClass" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.relationship.class.targetItemClass" label="targetItemClass">
                <sd:treePicker name="targetItemClass" value="${relationshipClass.targetItemClass}" source="cmdbItemClassTree"/>
                <form:errors path="targetItemClass" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.relationship.class.label" label="label">
                <form:input path="label" />
                <form:errors path="label" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.relationship.class.reverseLabel" label="reverseLabel">
                <form:input path="reverseLabel" />
                <form:errors path="reverseLabel" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.entity.class.description" label="description">
                <form:textarea path="description" rows="4" cols="60" />
                <form:errors path="description" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
