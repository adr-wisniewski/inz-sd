<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Incidents:</h1>

<form:form modelAttribute="searchCriteria" action="search_incidents" method="post">
	<form:errors path="*" cssClass="errors" />
	<table>
		<tr>
			<th>Subject:</th>
			<td><form:input path="subject" /></td>
		</tr>
		<tr>
			<th>Priority:</th>
			<td><form:select path="priority">
						<form:option value="-1" label="--Select--" />
						<form:options itemLabel="name" itemValue="code" items="${priorities}" />
					</form:select>
			</td>
		</tr>
		<tr>
			<th>Status:</th>
			<td>
				<form:select path="status">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${statuses}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<th>Impact:</th>
			<td>
				<form:select path="impact">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${impacts}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<th>Urgency:</th>
			<td>
				<form:select path="urgency">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${urgencies}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<th>Category:</th>
			<td>
				<form:select path="category">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${categories}" />
				</form:select>
			</td>
		</tr>
	</table>

	<div id="buttonGroup">
		<input type="submit" value="Search" />
	</div>
</form:form>


<c:if test="${empty incidents}">
	No incidents found
</c:if>

<form:form modelAttribute="selection" action="associate" method="post">
<c:if test="${not empty incidents}">
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>Subject</th>
				<th>Status</th>
				<th>Priority</th>
				<th>Impact</th>
				<th>Creation date</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${incidents}" var="incident">
			<tr>
				<td><form:checkbox path="selected" value="${incident.id}"></form:checkbox> </td>
				<td>${incident.id}</td>
				<td>${incident.subject}</td>
				<td>${incident.status.name}</td>
				<td>${incident.priority.name}</td>
				<td>${incident.impact.name}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${incident.creationDate}" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div id="buttonGroup">
		<input type="submit" value="Associate" />
	</div>
</c:if>
</form:form>