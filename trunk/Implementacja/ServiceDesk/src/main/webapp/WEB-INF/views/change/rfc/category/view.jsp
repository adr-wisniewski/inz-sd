<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="fieldgroup.change.rfc.category.all">
    <ui:propertyList>
        <ui:propertyItem code="field.change.rfc.category.id">
            ${rfcCategory.id}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.category.name">
            ${rfcCategory.name}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.category.parent">
            <link:rfcCategory object="${rfcCategory.parent}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.category.abstraction">
            <print:yesorno value="${rfcCategory.abstraction}" />
        </ui:propertyItem>
        
    </ui:propertyList>
    <p class="buttons">
        <ui:actionButton label="edit.label"
                         action="/change/rfc/category/${rfcCategory.id}/edit"
                         cssClass="edit" />

        <ui:actionButton label="delete.label"
                         action="/change/rfc/category/${rfcCategory.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>