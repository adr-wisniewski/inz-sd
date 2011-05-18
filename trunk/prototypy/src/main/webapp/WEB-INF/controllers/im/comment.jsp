<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Add comment (request: ${comment.requestId} ):</h1>


<form:form modelAttribute="comment" action="comment" method="post">
	<form:errors path="*" cssClass="errors" />
		<form:hidden path="requestId" />
	<fieldset>
		<div class="input">
			Text: <form:input path="text" /> <form:errors path="text" cssClass="error" />
		</div>
	</fieldset>
	<div id="buttonGroup">
		<input type="submit" value="Add" />
	</div>
</form:form>
