<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form modelAttribute="generator" action="${action_name}" method="post" cssClass="event_form">

<div class="buttonGroup">
	<input type="submit" value="<spring:message code="save.label" />" />
	<a href="<c:url value="/signal/preview?id=${generator.id}" />"><spring:message code="signal_preview.label" /></a>
</div>

<fieldset class="profile">
	<legend><spring:message code="signal_generator.label" /></legend>
	<table class="details_table">
		<tr>
			<th>ID:</th>
			<td>${generator.id}</td>
			
			<th><spring:message code="signal_lastRunDate.label" />:</th>
			<td><fmt:formatDate value="${generator.lastRunDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			
			<th><spring:message code="signal_lastRunStatus.label" />:</th>
			<td></td>
			
			<th><spring:message code="signal_enabled.label" />:</th>
			<td>
				<form:checkbox path="enabled" />
				<form:errors path="enabled" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th><spring:message code="signal_frequency.label" />:</th>
			<td>
				<form:input path="frequency" />
				<form:errors path="frequency" cssClass="error" />
			</td>
			
			<th><spring:message code="signal_receiver.label" />:</th>
			<td>
				<form:select path="receiverType">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="description" itemValue="code" items="${receiver_types}" />
				</form:select>
				<form:errors path="receiverType" cssClass="error" />
			</td>
			
			<th><spring:message code="signal_type.label" /></th>
			<td>
				<form:select path="type">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${signal_types}" />
				</form:select>
				<form:errors path="type" cssClass="error" />
			</td>
		</tr>
	</table>
	
	<div class="main_label"><spring:message code="signal_criterion.label" />:</div>
	<form:errors path="criterion" cssClass="error" />
	<form:textarea path="criterion" rows="2" cols="100" /> 

</fieldset>

<fieldset>
	<legend><spring:message code="details.label" /></legend>	
	<table class="tablesorter">
	<thead>
		<tr>
			<th><spring:message code="name.label" /></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${generator.type.objectType.attributeTypes}" var="a">
		<tr>
			<td>${a.name}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</fieldset>

</form:form>