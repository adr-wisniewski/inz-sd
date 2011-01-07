<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="search_problems.label" /></div>

<form:form modelAttribute="problemSearchCriteria" action="search" method="post">
	<form:errors path="*" cssClass="error" />
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Id</th>
				<th><spring:message code="subject.label" /></th>
				<th><spring:message code="creationDate.label" /></th>
				<th><spring:message code="status.label" /></th>
				<th><spring:message code="priority.label" /></th>
				<th><spring:message code="impact.label" /></th>
				<th><spring:message code="category.label" /></th>
				<th><spring:message code="supportGroupMember.label" /></th>
				<th><spring:message code="supportGroup.label" /></th>
			</tr>
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>
					<sd:intervalPicker nameFrom="startCreationDate" valueFrom="${problemSearchCriteria.startCreationDate}" valueTo="${problemSearchCriteria.endCreationDate}" nameTo="endCreationDate"/>
				</td>
				<td>
					<form:input path="subject" />
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

					<sd:treePicker name="category" value="${problemSearchCriteria.category}" source="categories_pm"/>
				</td>
				<td>
					<sd:employeePicker name="supportGroupMember" value="${problemSearchCriteria.supportGroupMember}"/>
					<form:errors path="supportGroupMember" cssClass="error" />
				</td>
				<td>
					<form:select path="supportGroup">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="id" items="${groups}" />
					</form:select>
					<br />
					<input type="submit" value="<spring:message code="search.label" />" class="button" />
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${problems}" var="problem">
			<tr>
				<td>${problem.id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${problem.creationDate}" /></td>
				<td><sd:problemLink label="${problem.subject}" id="${problem.id}"/></td>
				<td>${problem.status.name}</td>
				<td>${problem.priority.name}</td>
				<td>${problem.impact.name}</td>
				<td>${problem.category.name}</td>
				<td><sd:employeeLink employee="${problem.supportGroupMember}"/> </td>
				<td><sd:supportGroupLink group="${problem.supportGroup}"/></td>
			</tr>
		</c:forEach>
		<c:if test="${empty problems}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
