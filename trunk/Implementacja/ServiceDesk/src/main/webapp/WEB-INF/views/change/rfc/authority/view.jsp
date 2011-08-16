<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="fieldgroup.change.rfc.authority.all">
    <ui:propertyList>
        <ui:propertyItem code="field.change.rfc.authority.id">
            ${authority.id}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.authority.name">
            ${authority.name}
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.authority.cab">
            <print:yesorno value="${authority.cab}" />
        </ui:propertyItem>
        
    </ui:propertyList>
    <p class="buttons">
        <ui:actionButton label="edit.label"
                         action="/change/rfc/authority/${authority.id}/edit"
                         cssClass="edit" />

        <ui:actionButton label="delete.label"
                         action="/change/rfc/authority/${authority.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>
    
<ui:panel caption="field.change.rfc.authority.members">
    <ui:listView items="${authority.members}">
        <jsp:attribute name="label">
            <link:employee object="${item}"/>
        </jsp:attribute>
    </ui:listView>
</ui:panel>
    
<ui:panel caption="field.change.rfc.authority.categories">
    <ui:listView items="${authority.categories}">
        <jsp:attribute name="label">
            <link:rfcCategory object="${item}" />
        </jsp:attribute>
    </ui:listView>
</ui:panel>