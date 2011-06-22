<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="signals.label" /></div>

<table class="tablesorter">
	<thead>
		<tr>
			<th><spring:message code="signal_objectId.label" /></th>
			<th><spring:message code="signal_receiver.label" /></th>
			<th><spring:message code="signal_type.label" /></th>
			<th><spring:message code="signal_subject.label" /></th>
			<th><spring:message code="signal_message.label" /></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${signals}" var="s">
		<tr>
			<td>${s.objectId}</td>
			<td>${s.receiver.name}</td>
			<td>${s.type.name}</td>
			<td>${s.subject}</td>
			<td>${s.message}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

