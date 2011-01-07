<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="search_events.label" /></div>

<form:form modelAttribute="eventSearchCriteria" action="search" method="post">
	<form:errors path="*" cssClass="error" />
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
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>
					<sd:intervalPicker nameFrom="startCreationDate" valueFrom="${eventSearchCriteria.startCreationDate}" valueTo="${eventSearchCriteria.endCreationDate}" nameTo="endCreationDate"/>
				</td>
				<td>
					<sd:intervalPicker nameFrom="startEventDate" valueFrom="${eventSearchCriteria.startEventDate}" valueTo="${eventSearchCriteria.endEventDate}" nameTo="endEventDate"/>
				</td>
				<td>
					<form:input path="subject" />
				</td>
				<td>
					<form:select path="significance">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="code" items="${significance_types}" />
					</form:select>
				</td>
				<td>
					<sd:treePicker name="category" value="${eventSearchCriteria.category}" source="categories_em"/>
					<br />
					<input type="submit" value="<spring:message code="search.label" />" class="button" />
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${events}" var="event">
			<tr>
				<td>${event.id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${event.creationDate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${event.eventDate}" /></td>
				<td><sd:eventLink label="${event.subject}" id="${event.id}" /></td>
				<td>${event.significance.name}</td>
				<td>${event.category.name}</td>
			</tr>
		</c:forEach>
		<c:if test="${empty events}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
