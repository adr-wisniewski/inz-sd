<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<form:form modelAttribute="incident" action="add" method="post" cssClass="event_form">
	<form:errors path="*" cssClass="errors" />
	<fieldset>
		<legend><spring:message code="incident.label" /></legend>
		<div class="main_label"><spring:message code="subject.label" />:</div>
		<form:errors path="subject" cssClass="error" />
		<form:input path="subject" cssClass="subject_input" />
		
		<div class="main_label"><spring:message code="description.label" />:</div>
		<form:errors path="description" cssClass="error" />
		<form:textarea path="description" rows="2" cols="100" />  
	</fieldset>
	
<security:authorize ifAnyGranted="ADD_FOR_IM">
	<fieldset class="details">
		<legend><spring:message code="details.label" /></legend>			
			<table class="details_table">
				<tr>
					<th><spring:message code="by_author.label" />:</th>
					<td><sd:employeePicker name="author" value="${incident.author}"/></td>
					<td><form:errors path="author" cssClass="error"/></td>
				</tr>
				<tr>
					<th><spring:message code="incident_source.label" />:</th>
					<td>
						<form:select path="source">
							<form:options itemLabel="name" itemValue="code" items="${sources}" />
						</form:select>
						<form:errors path="source" cssClass="error" />
					</td>
				</tr>
			</table>
	</fieldset>
</security:authorize>	
	
	<div class="buttonGroup">
		<input type="submit" value=" <spring:message code="add.label" /> " />
	</div>
</form:form>
