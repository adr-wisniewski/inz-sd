<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="request" action="addd" method="post">
	<form:errors path="*" cssClass="errors" />
	<fieldset>
		<table>
			<tr>
				<th>Subject:</th>
				<td><form:input path="subject" /></td>
				<td><form:errors path="subject" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Description:</th>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
		</table>
	</fieldset>
	<div id="buttonGroup">
		<input type="submit" value="Add" />
	</div>
</form:form>
