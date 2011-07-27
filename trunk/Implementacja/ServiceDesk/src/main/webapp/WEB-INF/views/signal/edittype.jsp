<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form modelAttribute="signal_type" action="${action_name}" method="post" cssClass="event_form">

<div class="buttonGroup">
	<input type="submit" value="<spring:message code="save.label" />" />
</div>

<fieldset class="profile">
	<legend><spring:message code="signal_type.label" /></legend>
	<table class="details_table">
		<tr>
			<th>ID:</th>
			<td>${signal_type.id}</td>
			
			<th><spring:message code="signal_significance.label" />:</th>
			<td>
				<form:select path="significance">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${significance_types}" />
				</form:select>
				<form:errors path="significance" cssClass="error" />
			</td>
			
			<th><spring:message code="object_type.label" /></th>
			<td>
				<form:select path="objectType">
					<form:option value="" label="--Select--" />
					<form:options itemLabel="name" itemValue="code" items="${object_types}" />
				</form:select>
				<form:errors path="objectType" cssClass="error" />
			</td>
		</tr>
	</table>
	
	<div class="main_label"><spring:message code="name.label" />:</div>
	<form:errors path="name" cssClass="error" />
	<form:input path="name" cssClass="subject_input" />
	
	<div class="main_label"><spring:message code="signal_subject_template.label" />:</div>
	<form:errors path="subjectTemplate" cssClass="error" />
	<form:textarea path="subjectTemplate" rows="2" cols="100" /> 
	
	<div class="main_label"><spring:message code="signal_message_template.label" />:</div>
	<form:errors path="messageTemplate" cssClass="error" />
	<form:textarea path="messageTemplate" rows="2" cols="100" /> 
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
	<c:forEach items="${signal_type.objectType.attributeTypes}" var="a">
		<tr>
			<td>${a.name}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</fieldset>

</form:form>