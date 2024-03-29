<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="fieldgroup.change.rfc.new">
    <form:form modelAttribute="rfc" method="post">
        <ui:errorList fieldPrefix="field.change.rfc"/>
        <ui:propertyList>
            <ui:propertyItem code="field.change.rfc.title" label="title">
                <form:input path="title" />
                <form:errors path="title" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.description" label="description">
                <form:textarea path="description" />
                <form:errors path="description" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.category" label="category">
                <sd:treePicker name="category" value="${rfc.category}" source="rfcCategoriesTree"/>
                <form:errors path="category" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="add.label" cssClass="add" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
