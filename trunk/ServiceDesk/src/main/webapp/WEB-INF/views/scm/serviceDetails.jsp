<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="details.label" />:</div>

<table class="details_table">
	<tr>
		<th><spring:message code="name.label" />:</th>
		<td>${service.name}</td>
	</tr>
	<tr>
		<th><spring:message code="description.label" />:</th>
		<td>${service.description}</td>
	</tr>
	
	
	<tr>
		<th><spring:message code="serviceHours.label" />:</th>
		<td>${service.agreement.hours}</td>
	</tr>
	
	<tr>
		<th><spring:message code="availability.label" />:</th>
		<td>${service.agreement.availability}%</td>
	</tr>
	
	<tr>
		<th><spring:message code="resolutionTime.label" />:</th>
		<td>${service.agreement.resolutionTime}h</td>
	</tr>
	
</table>

<div class="main_label"><spring:message code="serviceManagers.label" />:</div>

<table>
<c:forEach items="${service.managers}" var="m">
	<tr>
		<td><sd:employeeLink employee="${m}"/></td>
	</tr>
</c:forEach>
</table>