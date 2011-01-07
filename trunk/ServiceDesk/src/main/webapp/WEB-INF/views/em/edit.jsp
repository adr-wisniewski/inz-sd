<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>


<form:form modelAttribute="event" action="edit" method="post" cssClass="event_form">
<%--
	<div class="buttonGroup">
		<input type="submit" value="<spring:message code="save.label" />" />
	</div>
 --%>
 
	<form:errors path="*" cssClass="error" />
	
	<fieldset class="profile">
		<legend><spring:message code="event.label" /></legend>
		<table class="details_table">
			<tr>
				<th>ID:</th>
				<td>${event.id}</td>
				
				<th><spring:message code="eventDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${event.eventDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="creationDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${event.creationDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
			<tr>
				<th><spring:message code="event_significance.label" />:</th>
				<td>${event.significance.name}</td>				
				<th><spring:message code="category.label" />:</th>
				<td>${event.category.name}</td>
			</tr>
		</table>
		

		<div class="main_label"><spring:message code="subject.label" />:</div>
		${event.subject}
		<%--
		<form:errors path="subject" cssClass="error" />
		<form:input path="subject" cssClass="subject_input" />
		 --%>
	</fieldset>
		
	<fieldset class="details">
		<legend><spring:message code="event_parameters.label" /></legend>
		<table class="tablesorter">
			<thead>
				<tr>
					<th><spring:message code="param_name.label" /></th>
					<th><spring:message code="param_value.label" /></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${event.parameters}" var="p">
				<tr>
					<td><strong>${p.name}</strong></td>
					<td>${p.value}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
<c:if test="${not empty event.incident}">
	<fieldset>
		<legend><spring:message code="incident.label" /></legend>
		<table class="tablesorter">
			<thead>
				<tr>
					<th>Id</th>
					<th><spring:message code="subject.label" /></th>
					<th><spring:message code="status.label" /></th>
					<th><spring:message code="priority.label" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${event.incident.id}</td>
					<td><sd:incidentLink label="${event.incident.subject}" id="${event.incident.id}" /></td>
					<td>${event.incident.status.name}</td>
					<td>${event.incident.priority.name}</td>
				</tr>
			</tbody>
	</table>
	</fieldset>
</c:if>
</form:form>