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
    <form:form modelAttribute="universalItemClass" method="post">
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
                <sd:treePicker name="parent" value="${universalItemClass.parent}" source="universalcmdbItemClassTree"/>
                <form:errors path="parent" cssClass="error" />
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