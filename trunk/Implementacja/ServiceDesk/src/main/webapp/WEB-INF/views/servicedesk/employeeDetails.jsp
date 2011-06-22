<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="details.label" />:</div>

<table class="details_table">
	<tr>
		<th><spring:message code="firstname.label" />:</th>
		<td>${employee.firstname}</td>
	</tr>
	<tr>
		<th><spring:message code="lastname.label" />:</th>
		<td>${employee.lastname}</td>
	</tr>
	<tr>
		<th><spring:message code="mobilePhone.label" />:</th>
		<td>${employee.mobilePhone}</td>
	</tr>
	<tr>
		<th><spring:message code="phoneNumber.label" />:</th>
		<td>${employee.phoneNumber}</td>
	</tr>
	<tr>
		<th><spring:message code="email.label" />:</th>
		<td>${employee.email}</td>
	</tr>
	<tr>
		<th><spring:message code="department.label" />:</th>
		<td>${employee.department.name}</td>
	</tr>
	<tr>
		<th><spring:message code="job.label" />:</th>
		<td>${employee.job.title}</td>
	</tr>
	<tr>
		<th><spring:message code="manager.label" />:</th>
		<td><sd:employeeLink employee="${employee.manager}" /></td>
	</tr>
</table>

<div class="main_label"><spring:message code="services.label" />:</div>

<table>
<c:forEach items="${employee.services}" var="s">
	<tr>
		<td><a class="standard_link" href="<c:url value="/scm/serviceDetails?id=${s.id}"/>">${s.name}</a></td>
	</tr>
</c:forEach>
</table>

<security:authorize access="hasRole('ADMIN')">
<div class="main_label"><spring:message code="authorities.label" />:</div>

<form:form modelAttribute="selection" action="editPrivileges" method="post">
	<table class="tablesorter">
		<thead>
			<tr>
				<th><spring:message code="authority.label"/></th>
				<th><spring:message code="has_authority.label"/></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${roles}" var="role">
			<tr>
				<td>${role.description}</td>
				<td><form:checkbox path="selected" value="${role.code}"></form:checkbox> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="buttonGroup">
		<input type="submit" value="<spring:message code="save.label" />" />
	</div>
</form:form>
</security:authorize>

