<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form modelAttribute="problem" action="edit" method="post" cssClass="event_form">
	<div class="buttonGroup">
<security:authorize access="hasRole('EDIT_PM')">
		<input type="submit" value="<spring:message code="save.label" />" />
</security:authorize>
<security:authorize access="hasRole('ADD_SOL')">	
		<sd:button url="/pm/solution?id=${problem.id}&amp;type=WORK" code="add_workaround.label"/>
		<sd:button url="/pm/solution?id=${problem.id}&amp;type=PERM" code="add_resolution.label"/>
</security:authorize>
<security:authorize access="hasRole('ASSOC_I_P')">
		<sd:button url="/pm/search_incidents?id=${problem.id}" code="associate_incidents.label"/>
</security:authorize>
	</div>
	
	<form:errors path="*" cssClass="error" />
	<fieldset class="profile">
		<legend><spring:message code="problem.label" /></legend>
		<table class="details_table">
			<tr>
				<th>ID:</th>
				<td>${problem.id}</td>
				
				<th><spring:message code="priority.label" />:</th>
				<td>${problem.priority.name}</td>
				
				<th><spring:message code="status.label" />:</th>
				<td>${problem.status.name}</td>
			</tr>
			<tr>
				
				<th><spring:message code="known_error.label" />:</th>
				<td>${problem.knownError}</td>
				
				<th><spring:message code="creationDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${problem.creationDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="closureDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${problem.closureDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</table>
		
		
		<div class="main_label"><spring:message code="subject.label" />:</div>
		<form:errors path="subject" cssClass="error" />
		<form:input path="subject" cssClass="subject_input" />
		
		<div class="main_label"><spring:message code="description.label" />:</div>
		<form:errors path="description" cssClass="error" />
		<form:textarea path="description" rows="2" cols="100" />  
	</fieldset>
	
	<fieldset class="details">
		<legend><spring:message code="details.label" /></legend>			
			<table class="details_table">
				<tr class="odd">
					<th><spring:message code="priority.label" />:</th>
					<td>
						<form:select path="priority">
							<form:option value="-1" label="--Select--" />
							<form:options itemLabel="name" itemValue="code" items="${priorities}" />
						</form:select>
						<form:errors path="priority" cssClass="error" />
					</td>
					<th><spring:message code="status.label" />:</th>
					<td>
						<form:select path="status">
							<form:option value="" label="--Select--" />
							<form:options itemLabel="name" itemValue="code" items="${statuses}" />
						</form:select>
						<form:errors path="status" cssClass="error" />
					</td>
				</tr>
				<tr class="even">
					<th><spring:message code="impact.label" />:</th>
					<td>
						<form:select path="impact">
							<form:option value="" label="--Select--" />
							<form:options itemLabel="name" itemValue="code" items="${impacts}" />
						</form:select>
					
						<form:errors path="impact" cssClass="error" />
					</td>
					<th><spring:message code="urgency.label" />:</th>
					<td>
						<form:select path="urgency">
							<form:option value="" label="--Select--" />
							<form:options itemLabel="name" itemValue="code" items="${urgencies}" />
						</form:select>
						<form:errors path="urgency" cssClass="error" />
					</td>
				</tr>
				<tr class="odd">
					<th><spring:message code="category.label" /></th>
					<td>
						<sd:treePicker name="category" value="${problem.category}" source="categories_pm"/>
						<form:errors path="category" cssClass="error" />
					</td>
					<th><spring:message code="knownError.label" /></th>
					<td>
						<form:checkbox path="knownError"/>
						<form:errors path="knownError" cssClass="error" />
					</td>
				</tr>
				<tr class="even">
					<th><spring:message code="supportGroupMember.label" />:</th>
					<td>
						<sd:employeePicker name="supportGroupMember" value="${problem.supportGroupMember}"/>
						<form:errors path="supportGroupMember" cssClass="error" />
					</td>
					<th><spring:message code="supportGroup.label" />:</th>
					<td>
						<form:select path="supportGroup">
							<form:option value="" label="--Select--" />
							<form:options itemLabel="name" itemValue="id" items="${groups}" />
						</form:select>
						<form:errors path="supportGroup" cssClass="error" />
					</td>
				</tr>
			</table>
	</fieldset>
	
	<fieldset class="details">
		<legend><spring:message code="analisys.label" /></legend>	
		<div class="main_label"><spring:message code="impact.label" />:</div>
		<form:errors path="impactDetails" cssClass="error" />
		<form:textarea path="impactDetails" rows="2" cols="100" />
		
		<div class="main_label"><spring:message code="rootCause.label" />:</div>
		<form:errors path="rootCause" cssClass="error" />
		<form:textarea path="rootCause" rows="2" cols="100" />
		
		<div class="main_label"><spring:message code="symptoms.label" />:</div>
		<form:errors path="symptomsDetails" cssClass="error" />
		<form:textarea path="symptomsDetails" rows="2" cols="100" />
	</fieldset>
	
	<fieldset>
		<legend><spring:message code="solution.label" /></legend>
		<div class="main_label">
			<spring:message code="workaround.label" />:
<security:authorize access="hasRole('ADD_SOL')">				
			<a href="<c:url value="/pm/solution?id=${problem.id}&amp;type=WORK" />"><img src="<c:url value="/static/images/edit.gif"/>" alt="<spring:message code="edit.label" />" /></a>
</security:authorize>		
		</div>
		${problem.workaround.description}
		
		<div class="main_label">
			<spring:message code="resolution.label" />:
<security:authorize access="hasRole('ADD_SOL')">
			<a href="<c:url value="/pm/solution?id=${problem.id}&amp;type=PERM" />"><img src="<c:url value="/static/images/edit.gif" />" alt="<spring:message code="edit.label" />" /></a>
</security:authorize>
		</div>
		${problem.permanentSolution.description}
	</fieldset>

	<fieldset>
		<legend><spring:message code="incidents.label" /></legend>
		<table class="tablesorter">
			<thead>
				<tr>
					<th>Id</th>
					<th><spring:message code="subject.label" /></th>
					<th><spring:message code="status.label" /></th>
					<th><spring:message code="priority.label" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${problem.incidents}" var="incident">
				<tr>
					<td>${incident.id}</td>
					<td><sd:incidentLink label="${incident.subject}" id="${incident.id}" /></td>
					<td>${incident.status.name}</td>
					<td>${incident.priority.name}</td>
					<td><a href="<c:url value="/pm/delete_incident?incidentId=${incident.id}" />"><spring:message code="delete.label" /></a></td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
	</fieldset>
</form:form>


<form:form modelAttribute="comment" action="addcomment" method="post" cssClass="event_form">
	<fieldset>
		<legend>Komentarze</legend>
		<table class="comments_table">
			<c:forEach items="${comments}" var="comment">
			<tr>
				<td>
					<strong>${comment.author.firstname} ${comment.author.lastname}, <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${comment.creationDate}" /></strong>
					<br />
					${comment.text}
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<form:textarea path="text" rows="2" cols="200"/>
					<form:errors path="text" cssClass="error" />
					<input class="submit_image" src="<c:url value="/static/images/default/dd/drop-add.gif" />" value="Submit" alt="Dodaj" name="dodaj" type="image" />
				</td>
			</tr>
		</table> 
	</fieldset>
</form:form>