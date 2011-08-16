<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@taglib prefix="link" tagdir="/WEB-INF/tags/link" %>


<ui:panel caption="fieldgroup.change.rfc.edit">
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
            
            <ui:propertyItem code="field.change.rfc.author">
                <link:user object="${rfc.author}" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.creationTime">
                <print:datetime datetime="${rfc.timestamp}" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.category" label="category">
                <sd:treePicker name="category" value="${rfc.category}" source="rfcCategoriesTree"/>
                <form:errors path="category" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.priority" label="priority">
               <form:select path="priority" itemLabel="name" itemValue="id" items="${priorities}" />
                <form:errors path="priority" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.impact" label="impact">
                <form:select path="impact" itemLabel="name" itemValue="id" items="${impacts}" />
                <form:errors path="impact" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.resolution" label="resolution">
                <form:select path="resolution" itemLabel="name" itemValue="id" items="${resolutions}" />
                <form:errors path="resolution" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.state" label="state">
                <form:select path="state" itemLabel="name" itemValue="id" items="${states}" />
                <form:errors path="state" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.manager" label="manager">
                <sd:employeePicker name="manager" value="${rfc.manager}"/>
                <form:errors path="manager" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.builder" label="builder">
                <sd:employeePicker name="builder" value="${rfc.builder}"/>
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.authority" label="authority">
                <form:select multiple="true" path="authority" itemLabel="name" itemValue="id" items="${authorities}" />
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.cab" label="cab">
                <form:select multiple="true" path="cab" itemLabel="name" itemValue="id" items="${cabs}" />
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.pir" label="pir">
                <form:textarea path="pir" />
                <form:errors path="pir" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem>
                 <ui:submit code="edit.label" cssClass="edit" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>