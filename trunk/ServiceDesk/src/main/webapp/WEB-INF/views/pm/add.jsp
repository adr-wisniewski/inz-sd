<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form modelAttribute="problem" action="add" method="post" cssClass="event_form">
	<input type="hidden" name="incidentId" value="${incidentId}" />
	<form:errors path="*" cssClass="errors" />
	<fieldset>
		<legend><spring:message code="problem.label" /></legend>
		<div class="main_label"><spring:message code="subject.label" />:</div>
		<form:errors path="subject" cssClass="error" />
		<form:input path="subject" cssClass="subject_input" />
		
		<div class="main_label"><spring:message code="description.label" />:</div>
		<form:errors path="description" cssClass="error" />
		<form:textarea path="description" rows="2" cols="100" />  
	</fieldset>
	<div class="buttonGroup">
		<input type="submit" value=" <spring:message code="add.label" /> " />
	</div>
</form:form>
