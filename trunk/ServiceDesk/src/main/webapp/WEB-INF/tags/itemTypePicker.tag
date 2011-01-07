<%@ tag body-content="empty" description="Kontrolka do wyboru pracownika" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="true" type="sd.cmdb.domain.ItemType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<input type="hidden" id="${name}" name="${name}" value="${value.id}" />
<input type="text" value="${value.firstname} ${value.lastname}" id="employeePicker-${name}" readonly="readonly" onclick="window.open('<c:url value="/sd/employeePicker?name=${name}" />', 'Employee', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=yes,channelmode=no').focus();" />
<c:if test="${not empty value}">
<a onclick="window.open('<c:url value="/cmdb/itemtype/${value.id}" />', 'Employee', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=no,channelmode=no').focus(); return false;" href="#" class="standard_link"><spring:message code="details.label" /></a>
</c:if>
	