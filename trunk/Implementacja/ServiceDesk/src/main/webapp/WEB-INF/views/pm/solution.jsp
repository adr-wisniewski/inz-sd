<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form modelAttribute="solution" action="solution" method="post" cssClass="event_form">
	<form:errors path="*" cssClass="error" />
	<input type="hidden" name="problemId" value="${problemId}" />
	<fieldset>
		<legend><spring:message code="solution.label" /></legend>
			<div class="main_label"><spring:message code="subject.label" />:</div>
			<form:errors path="subject" cssClass="error" />
			<form:input path="subject" cssClass="subject_input" />
			
			<div class="main_label"><spring:message code="description.label" />:</div>
			<form:errors path="description" cssClass="error" />
			<form:textarea path="description" rows="2" cols="100" />
	</fieldset>
	
	<div class="buttonGroup">
		<input type="submit" value="<spring:message code="save.label" />" />
	</div>
</form:form>