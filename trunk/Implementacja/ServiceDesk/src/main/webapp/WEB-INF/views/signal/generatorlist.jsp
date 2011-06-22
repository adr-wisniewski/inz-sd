<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="signal_generators.label" /></div>

<table class="tablesorter">
	<thead>
		<tr>
			<th>Id</th>
			<th><spring:message code="signal_type.label" /></th>
			<th><spring:message code="signal_receiver.label" /></th>
			<th><spring:message code="signal_enabled.label" /></th>
			<th><spring:message code="signal_lastRunDate.label" /></th>
			<th><spring:message code="signal_frequency.label" /></th>
			<th><spring:message code="signal_nextRunDate.label" /></th>
			<th><spring:message code="signal_errormessage.label" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${generators}" var="g">
		<tr>
			<td>${g.id}</td>
			<td>${g.type.name}</td>
			<td>${g.receiverType.description}</td>
			<td>${g.enabled}</td>
			<td><fmt:formatDate value="${g.lastRunDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${g.frequency}</td>
			<td><fmt:formatDate value="${g.nextRunDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${g.errorMessage}</td>
			<td><sd:editButton url="/signal/editgenerator?id=${g.id}"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

