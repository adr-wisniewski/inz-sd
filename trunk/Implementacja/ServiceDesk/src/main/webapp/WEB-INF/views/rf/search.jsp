<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="search_request.label" /></div>

<form:form modelAttribute="requestSearchCriteria" action="search" method="post">
	<form:errors path="*" cssClass="error" />
	<table class="tablesorter">
		<thead>
			<tr>
				<th>Id</th>
				<th><spring:message code="creationDate.label" /></th>
				<th><spring:message code="author.label" /></th>
				<th><spring:message code="category.label" /></th>
				<th><spring:message code="status.label" /></th>
				<th><spring:message code="priority.label" /></th>
				<th><spring:message code="supportGroupMember.label" /></th>
				<th><spring:message code="supportGroup.label" /></th>
			</tr>
			<tr>
				<td>
					<form:input path="id" />
				</td>
				<td>		
					<sd:intervalPicker nameFrom="startCreationDate" valueFrom="${requestSearchCriteria.startCreationDate}" valueTo="${requestSearchCriteria.endCreationDate}" nameTo="endCreationDate"/>
				</td>
				<td>
					<sd:employeePicker name="author" value="${requestSearchCriteria.author}" />
				</td>
				<td>
					<sd:treePicker name="category" value="${requestSearchCriteria.category}" source="rfCategoriesTree"/>
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
					<sd:employeePicker name="supportGroupMember" value="${requestSearchCriteria.supportGroupMember}"/>
					<form:errors path="supportGroupMember" cssClass="error" />
				</td>
				<td>
					<form:select path="supportGroup">
						<form:option value="" label="Dowolny" />
						<form:options itemLabel="name" itemValue="id" items="${groups}" />
					</form:select>
					<br />
					<input type="submit" value="<spring:message code="search.label" />" class="button"/>
				</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requests}" var="request">
			<tr>
				<td><sd:requestLink label="${request.id}" id="${request.id}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${request.creationDate}" /></td>
				<td><sd:employeeLink employee="${request.author}" /></td>
				<td>${request.category.name}</td>
				<td>${request.status.name}</td>
				<td>${request.priority.name}</td>
				<td><sd:employeeLink employee="${incident.supportGroupMember}"/> </td>
				<td><sd:supportGroupLink group="${incident.supportGroup}"/></td>
			</tr>
		</c:forEach>
		<c:if test="${empty requests}">
			<tr>
				<td colspan="20"><spring:message code="no_result.label" /></td>
			</tr>
		</c:if>
		</tbody>
	</table>
</form:form>
