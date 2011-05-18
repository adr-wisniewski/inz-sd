<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form modelAttribute="request" action="edit" method="post" cssClass="event_form">

<div class="buttonGroup">
	<input type="submit" value="<spring:message code="save.label" />" />
</div>

<fieldset class="profile">
	<legend><spring:message code="request.label" /></legend>
	<table class="details_table">
			<tr>
				<th>ID:</th>
				<td>${request.id}</td>
				
				<th><spring:message code="by_author.label" />:</th>
				<td>
					<c:choose>
						<c:when test="${empty request.id}">
							<security:authorize ifAnyGranted="1_LINE,ADMIN">
								<sd:employeePicker name="author" value="${request.author}"/>
							</security:authorize>
						</c:when>
						<c:otherwise>
							${request.author.firstname} ${request.author.lastname}
						</c:otherwise>
					</c:choose>
				</td>
				
				<th><spring:message code="category.label" /></th>
				<td>${request.category.name}</td>
				
				<th><spring:message code="status.label" />:</th>
				<td>${request.status.name}</td>
			</tr>
			<tr>
				<th><spring:message code="targetResolutionDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${request.targetResolutionDate}" pattern="yyyy-MM-dd HH:mm"/></td> 
				 
				<th><spring:message code="creationDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${request.creationDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				
				<th><spring:message code="closureDate.label" />:</th>
				<td class="date"><fmt:formatDate value="${request.closureDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</table>
</fieldset>

<fieldset>
	<legend><spring:message code="details.label" /></legend>	
	<table class="details_table">
<security:authorize access="hasRole('EDIT_RF')">	
	<tr>
		<th><spring:message code="priority.label" />:</th>
		<td>
			<form:select path="priority">
				<form:option value="-1" label="--Select--" />
				<form:options itemLabel="name" itemValue="code" items="${priorities}" />
			</form:select>
			<form:errors path="priority" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="status.label" />:</th>
		<td>
			<form:select path="status">
				<form:option value="" label="--Select--" />
				<form:options itemLabel="name" itemValue="code" items="${statuses}" />
			</form:select>
			<form:errors path="status" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="supportGroupMember.label" />:</th>
		<td>
			<sd:employeePicker name="supportGroupMember" value="${request.supportGroupMember}"/>
			<form:errors path="supportGroupMember" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="supportGroup.label" />:</th>
		<td>
			<form:select path="supportGroup">
				<form:option value="" label="--Select--" />
				<form:options itemLabel="name" itemValue="id" items="${groups}" />
			</form:select>
			<form:errors path="supportGroup" cssClass="error" />
		</td>
	</tr>
</security:authorize>	
	<c:forEach items="${request.attributes}" var="a" varStatus="loopStatus">
	<tr>
		<th>${a.attributeType.name}</th>
		<td>
		<c:choose>
			<c:when test='${a.attributeType.inputType == "text"}'>
				<form:input path="attributes[${loopStatus.index}].value"/>
			</c:when>
			<c:when test='${a.attributeType.inputType == "textarea"}'>
				<form:textarea path="attributes[${loopStatus.index}].value"/>
			</c:when>
		</c:choose>
		<c:if test="${a.attributeType.required}">
			<span style="color: red">*</span>
		</c:if>
			<form:errors path="attributes[${loopStatus.index}].value" cssClass="error" />
		</td>
	</tr>
	</c:forEach>
	</table>
</fieldset>

</form:form>

<c:if test="${not empty request.id}">

<form:form modelAttribute="comment" action="addcomment" method="post" cssClass="event_form">
	<fieldset class="comments">
		<legend><spring:message code="comments.label" /></legend>
		<table class="comments_table">
			<c:forEach items="${request.comments}" var="comment">
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

</c:if>