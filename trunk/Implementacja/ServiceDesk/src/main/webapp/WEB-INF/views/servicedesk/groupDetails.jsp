<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="details.label" />:</div>

<table class="details_table">
	<tr>
		<th><spring:message code="name.label" />:</th>
		<td>${group.name}</td>
	</tr>
	<tr>
		<th><spring:message code="manager.label" />:</th>
		<td><sd:employeeLink employee="${group.manager}" /></td>
	</tr>
</table>

<div class="main_label"><spring:message code="members.label" />:</div>

<table class="tablesorter">
	<thead>
		<tr>
			<th>Login</th>
			<th><spring:message code="firstname.label" /></th>
			<th><spring:message code="lastname.label" /></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${group.members}" var="e">
		<tr>
			<td><sd:employeeLink label="${e.login}" employee="${e}" /></td>
			<td><sd:employeeLink label="${e.firstname}" employee="${e}" /></td>
			<td><sd:employeeLink label="${e.lastname}" employee="${e}" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>