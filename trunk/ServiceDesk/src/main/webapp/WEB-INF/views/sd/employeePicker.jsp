<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="main_label"><spring:message code="search_employees.label" /></div>

<form:form modelAttribute="employeeSearchCriteria" action="employeePicker" method="post">
	<form:errors path="*" cssClass="error" />
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Id</th>
				<th>Login</th>
				<th><spring:message code="firstname.label" /></th>
				<th><spring:message code="lastname.label" /></th>
				<th></th>
			</tr>
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>
					<form:input path="login" />
				</td>
				<td>
					<form:input path="firstname" />
				</td>
				<td>
					<form:input path="lastname" />
				</td>
				<td>
					<input type="submit" value="<spring:message code="search.label" />" class="button"/>
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${employees}" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.login}</td>
				<td>${e.firstname}</td>
				<td>${e.lastname}</td>
				<td><a href="<c:url value="/sd/employeePickerChoose?id=${e.id}" />" class="standard_link"> <spring:message code="choose.label" />  </a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty employees}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
