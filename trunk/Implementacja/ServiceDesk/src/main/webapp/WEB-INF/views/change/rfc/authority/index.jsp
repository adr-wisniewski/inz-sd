<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="caption.change.rfc.authority.list">
    <ui:listView items="${authorities}">
        <jsp:attribute name="label">
            <a href="/change/rfc/authority/${item.id}"><c:out value="${item.name}" /></a>
        </jsp:attribute>
    </ui:listView>
    
    <p class="buttons">
        <ui:actionButton label="add.label" cssClass="add" action="/change/rfc/authority/add" />
    </p>
</ui:panel>