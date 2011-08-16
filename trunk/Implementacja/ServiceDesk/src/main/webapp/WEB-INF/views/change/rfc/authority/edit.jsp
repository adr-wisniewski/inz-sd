<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />
<ui:panel caption="fieldgroup.change.rfc.authority.all">
    <form:form modelAttribute="authority" method="post">
        <ui:errorList fieldPrefix="field.change.rfc.authority"/>
        <ui:propertyList>
            
            <ui:propertyItem code="field.change.rfc.authority.name" label="name">
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.authority.cab" label="cab">
                <form:checkbox path="cab" />
                <form:errors path="cab" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.authority.categories" label="categories">
                <form:select multiple="true" itemLabel="name" itemValue="id" path="categories" items="${categories}" />
                <form:errors path="cab" cssClass="categories" />
            </ui:propertyItem>    
                
            <ui:propertyItem code="field.change.rfc.authority.members" label="members">
                <form:select multiple="true" itemLabel="firstname" itemValue="id" path="members" items="${employees}" />
                <form:errors path="cab" cssClass="members" />
            </ui:propertyItem>        

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>