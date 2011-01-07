<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="search_errors.label" /></div>

<form:form modelAttribute="searchCriteria" action="kedb" method="post">
	<form:errors path="*" cssClass="error" />
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Id</th>
				<th><spring:message code="subject.label" /></th>
				<th><spring:message code="category.label" /></th>
				<th><spring:message code="symptoms.label" /></th>
				<th><spring:message code="rootCause.label" /></th>
				<th><spring:message code="workaround.label" /></th>
			</tr>
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>
					<form:input path="subject" />
				</td>
				<td>
					<sd:treePicker name="category" value="${searchCriteria.category}" source="categories_pm"/>
				</td>
				<td></td>
				<td></td>
				<td>
					<input type="submit" value="<spring:message code="search.label" />" class="button" />
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${known_errors}" var="error">
			<tr>
				<td>${error.id}</td>
				<td><sd:problemLink label="${error.subject}" id="${error.id}"/></td>
				<td>${error.category.name}</td>
				<td>${error.symptoms}</td>
				<td>${error.rootCause}</td>
				<td>${error.workaround}</td>
			</tr>
		</c:forEach>
		<c:if test="${empty known_errors}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
