<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="fieldgroup.change.rfc.edit">
    <form:form modelAttribute="rfc" method="post">
        <ui:errorList/>
        <ui:propertyList>
            <ui:propertyList>
                 <ui:propertyItem code="field.change.rfc.id">
                    ${rfc.id}
                </ui:propertyItem>
            </ui:propertyList>
            
            <ui:propertyItem code="field.change.rfc.title" label="title">
                <form:input path="title" />
                <form:errors path="title" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.description" label="description">
                <form:textarea path="description" />
                <form:errors path="description" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.priority">
               <form:select path="priority">
                    <form:options itemLabel="name" itemValue="id" items="${priorities}" />
                </form:select>
                <form:errors path="priority" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.impact">
                <form:select path="impact">
                    <form:options itemLabel="name" itemValue="id" items="${impacts}" />
                </form:select>
                <form:errors path="impact" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.state">
                <form:select path="state">
                    <form:option label="" value="" />
                    <form:options itemLabel="name" itemValue="id" items="${states}" />
                </form:select>
                <form:errors path="state" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.creator">
                <link:employee object="${rfc.creator}" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.creationTime">
                <print:datetime datetime="${rfc.timestamp}" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.manager">
                <sd:employeePicker name="manager" value="${rfc.manager}"/>
                <form:errors path="manager" cssClass="error"/>
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="edit.label" cssClass="edit" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>