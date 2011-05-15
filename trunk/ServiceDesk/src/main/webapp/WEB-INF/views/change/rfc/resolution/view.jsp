<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="change" tagdir="/WEB-INF/tags/ui/change" %>

<ui:panel caption="fieldgroup.change.rfc.resolution.all">
    <ui:propertyList>
        <ui:propertyItem code="field.change.rfc.resolution.id">
            ${rfcResolution.id}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.resolution.name">
            ${rfcResolution.name}
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.resolution.order">
            ${rfcResolution.order}
        </ui:propertyItem>
    </ui:propertyList>
    <p class="buttons">
        <ui:actionButton label="edit.label"
                         action="/change/rfc/resolution/${rfcResolution.id}/edit"
                         cssClass="edit" />

        <ui:actionButton label="delete.label"
                         action="/change/rfc/resolution/${rfcResolution.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>