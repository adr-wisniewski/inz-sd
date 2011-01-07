<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form modelAttribute="incident" action="edit" method="post" cssClass="event_form">
	<div class="buttonGroup">
<security:authorize access="hasRole('EDIT_IM')">	
		<input type="submit" value="<spring:message code="save.label" />" />
</security:authorize>
<security:authorize access="hasRole('ADD_PM')">
		<sd:button url="/pm/addFromIncident?incidentId=${incident.id}" code="add_problem.label"/>
</security:authorize>
                <sd:acceptIncident incident="${incident}" />
	</div>

	<form:errors path="*" cssClass="errors" />
	
	<fieldset class="profile">
		<legend><spring:message code="incident.label" /></legend>
		<table class="details_table">
			<tr>
				<th>ID:</th>
				<td>${incident.id}</td>
				
				<th><spring:message code="priority.label" />:</th>
				<td>${incident.priority.name}</td>
				
				<th><spring:message code="status.label" />:</th>
				<td>${incident.status.name}</td>
				
				<th><spring:message code="by_author.label" />:</th>
				<td>${incident.author.firstname} ${incident.author.lastname}</td>
			</tr>
			<tr>
				<th><spring:message code="creationDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${incident.creationDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="targetResolutionDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${incident.targetResolutionDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="resolutionDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${incident.resolutionDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="closureDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${incident.closureDate}" pattern="yyyy-MM-dd HH:mm"/></td>
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
				<tr class="even">
					<th><spring:message code="service.label" />:</th>
					<td colspan="3">
						<form:select path="service">
							<form:option value="-1" label="--Select--" />
							<form:options itemLabel="name" itemValue="id" items="${incident.author.services}" />
						</form:select>
						<a href="<c:url value="/scm/serviceDetails?id=${incident.service.id}"/>"><spring:message code="details.label"/></a>
						<form:errors path="service" cssClass="error" />
					</td>
				</tr>
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
						<sd:treePicker name="category" value="${incident.category}" source="categories_im"/>
						<form:errors path="category" cssClass="error" />
					</td>
					<th><spring:message code="incident_source.label" />:</th>
					<td>
						${incident.source.name}
					</td>
				</tr>
				<tr class="even">
					<th><spring:message code="supportGroupMember.label" />:</th>
					<td>
						<sd:employeePicker name="supportGroupMember" value="${incident.supportGroupMember}"/>
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


		<div class="main_label"><spring:message code="resolution.label" />:</div>
		<form:errors path="resolution" cssClass="error" />
		<form:textarea path="resolution" rows="2" cols="200" />
		
	</fieldset>
	
	<fieldset class="author_details">
		<legend><spring:message code="author_details.label" /></legend>
		<table class="details_table">
			<tr>
				<th><spring:message code="firstname.label" />:</th>
				<td>${incident.author.firstname}</td>
				<th><spring:message code="lastname.label" />:</th>
				<td>${incident.author.lastname}</td>
			</tr>
			<tr>
				<th><spring:message code="mobilePhone.label" />:</th>
				<td>${incident.author.mobilePhone}</td>
				<th><spring:message code="phoneNumber.label" />:</th>
				<td>${incident.author.phoneNumber}</td>
				<th><spring:message code="email.label" />:</th>
				<td>${incident.author.email}</td>
			</tr>
		</table>
		
		<div class="main_label"><spring:message code="user_ci.label" />:</div>
		
		<table class="tablesorter">
			<thead>
				<tr>
					<th>ID</th>
					<th><spring:message code="ci_name.label" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>14/asd/123</td>
					<td>Monitor</td>
				</tr>
				<tr>
					<td>321/FGJ/3432</td>
					<td>Klawiatura</td>
				</tr>
			</tbody>
		</table>
	</fieldset>

        <c:if test="${empty incidents}">
            <fieldset>
                <legend><spring:message code="events.label" /></legend>

            	<table class="tablesorter">
			<thead>
                            <tr>
                                    <th>Id</th>
                                    <th><spring:message code="creationDate.label" /></th>
                                    <th><spring:message code="eventDate.label" /></th>
                                    <th><spring:message code="subject.label" /></th>
                                    <th><spring:message code="event_significance.label" /></th>
                                    <th><spring:message code="category.label" /></th>
                            </tr>
			</thead>
			<tbody>
                            <c:forEach items="${incident.events}" var="event">
                            <tr>
                                    <td>${event.id}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${event.creationDate}" /></td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${event.eventDate}" /></td>
                                    <td><sd:eventLink label="${event.subject}" id="${event.id}" /></td>
                                    <td>${event.significance.name}</td>
                                    <td>${event.category.name}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
		</table>


            </fieldset>
        </c:if>

	<sd:history actionsList="${history}"/>
</form:form>

<security:authorize access="hasRole('COMMENT_IM')">
<form:form modelAttribute="comment" action="addcomment" method="post" cssClass="event_form">
	<fieldset class="comments">
		<legend><spring:message code="comments.label" /></legend>
		<table class="comments_table">
			<c:forEach items="${incident.comments}" var="comment">
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
</security:authorize>

