<%@ tag body-content="empty" description="Kontrolka do wyboru pracownika" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="true" type="servicedesk.core.base.employee.domain.Employee" %>
<%@ attribute name="cssClass" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/servicedesk/employeeDetails?id=${value.id}" var="url" />

<input type="hidden" id="${name}" name="${name}" value="${value.id}" />
<input class="picker ${cssClass}}" type="text" value="${value.firstname} ${value.lastname}" id="employeePicker-${name}" readonly="readonly" onclick="window.open('<c:url value="/servicedesk/employeePicker?name=${name}" />', 'Employee', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=yes,channelmode=no').focus();" />
<c:if test="${not empty value}">
<a onclick="window.open('${url}', 'Employee', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=no,channelmode=no').focus(); return false;" href="#" class="standard_link"><spring:message code="details.label" /></a>
</c:if>
	