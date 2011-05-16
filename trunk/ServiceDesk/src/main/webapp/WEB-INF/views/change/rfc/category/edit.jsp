<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="fieldgroup.change.rfc.category.all">
    <form:form modelAttribute="rfcCategory" method="post">
        <ui:errorList fieldPrefix="field.change.rfc.category"/>
        <ui:propertyList>
            
            <ui:propertyItem code="field.change.rfc.category.name" label="name">
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.category.parent" label="parent">
                <sd:treePicker name="parent" value="${rfcCategory.parent}" source="rfccategory_change"/>
                <form:errors path="parent" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.category.abstraction" label="abstraction">
                <form:checkbox path="abstraction" />
                <form:errors path="abstraction" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>