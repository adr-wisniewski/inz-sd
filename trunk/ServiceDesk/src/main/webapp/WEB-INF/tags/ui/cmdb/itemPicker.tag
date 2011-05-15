<%@ tag body-content="empty" description="Kontrolka do wyboru elementu konfiguracji" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="true" type="servicedesk.cmdb.domain.Item" %>
<%@ attribute name="clazz" required="true" type="servicedesk.cmdb.domain.ItemClass" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="pick_script">
    window.open('<c:url value="/cmdb/item/picker/class/${clazz.id}/${name}" />', '_blank', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=yes,channelmode=no').focus();
</c:set>

<input type="hidden" id="${name}" name="${name}" value="${value.id}" />
<input class="picker" type="text" value="${value.label}" id="itemPicker-${name}" readonly="readonly" onclick="${pick_script}" />

<c:if test="${not empty value}">
    <a href="/cmdb/item/${value.id}" target="_blank" class="standard_link">
        <spring:message code="details.label" />
    </a>
</c:if>
