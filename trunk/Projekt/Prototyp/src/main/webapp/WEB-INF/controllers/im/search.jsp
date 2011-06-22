<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Requests:</h1>

<c:if test="${empty requests}">
	No requests found
</c:if>

<form:form modelAttribute="requestSearchCriteria" action="search" method="post">
	<form:errors path="*" cssClass="errors" />
	<fieldset>
		<div class="input">
			Subject: <form:input path="subject" />
		</div>
	</fieldset>
	<div id="buttonGroup">
		<input type="submit" value="Search" />
	</div>
</form:form>

<c:if test="${not empty requests}">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Subject</th>
				<th>Status</th>
				<th>Priority</th>
				<th>Impact</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requests}" var="request">
			<tr>
				<td>${request.id}</td>
				<td> <a href="<c:url value="/im/edit?id=${request.id}" />"><c:out value="${request.subject}" /></a></td>
				<td>${request.status.name}</td>
				<td>${request.priority}</td>
				<td>${request.impact.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
