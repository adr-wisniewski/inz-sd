<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="search_incidents.label" /></div>

<form:form modelAttribute="incidentSearchCriteria" action="search" method="post">
	<form:errors path="*" cssClass="error" />
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Id</th>
				<th><spring:message code="creationDate.label" /></th>
				<th><spring:message code="subject.label" /></th>
				<th><spring:message code="author.label" /></th>
				<th><spring:message code="status.label" /></th>
				<th><spring:message code="priority.label" /></th>
				<th><spring:message code="impact.label" /></th>
				<th><spring:message code="category.label" /></th>
				<th><spring:message code="supportGroupMember.label" /></th>
				<th><spring:message code="supportGroup.label" /></th>
                                <th></th>
			</tr>
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>
					<sd:intervalPicker nameFrom="startCreationDate" valueFrom="${incidentSearchCriteria.startCreationDate}" valueTo="${incidentSearchCriteria.endCreationDate}" nameTo="endCreationDate"/>
				</td>
				<td>
					<form:input path="subject" />
				</td>
				<td>
					<sd:employeePicker name="author" value="${incidentSearchCriteria.author}" />
				</td>
				<td>
					<form:select path="status">
						<form:option value="" label="Dowolny"  />
						<form:options itemLabel="name" itemValue="code" items="${statuses}" />
					</form:select>
				</td>
				<td>
					<form:select path="priority">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="code" items="${priorities}" />
					</form:select>
				</td>
				<td>
					<form:select path="impact">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="code" items="${impacts}" />
					</form:select>
				</td>
				<td>
					<sd:treePicker name="category" value="${incidentSearchCriteria.category}" source="imCategoriesTree"/>
				</td>
				<td>
					<sd:employeePicker name="supportGroupMember" value="${incidentSearchCriteria.supportGroupMember}"/>
					<form:errors path="supportGroupMember" cssClass="error" />
				</td>
				<td>
					<form:select path="supportGroup">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="id" items="${groups}" />
					</form:select>
				</td>
                                <td>
                                    <input type="submit" value="<spring:message code="search.label" />" class="button" />
                                </td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${incidents}" var="incident">
			<tr>
				<td>${incident.id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${incident.creationDate}" /></td>
				<td><sd:incidentLink label="${incident.subject}" id="${incident.id}" /></td>
				<td><sd:employeeLink employee="${incident.author}"/> </td>
				<td>${incident.status.name}</td>
				<td>${incident.priority.name}</td>
				<td>${incident.impact.name}</td>
				<td>${incident.category.name}</td>
				<td><sd:employeeLink employee="${incident.supportGroupMember}"/> </td>
				<td><sd:supportGroupLink group="${incident.supportGroup}"/></td>
                                <td><sd:acceptIncident incident="${incident}"/></td>
			</tr>
		</c:forEach>
		<c:if test="${empty incidents}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
