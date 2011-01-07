<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty succesmessage}">
<div id="success">
	${succesmessage}
</div>
</c:if>


<form:form modelAttribute="request" action="edit" method="post">
	<form:errors path="*" cssClass="errors" />
	<fieldset>
		<legend>Szczegoly</legend>
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
			<tr>
				<th>Priority:</th>
				<td>
					<form:select path="priority">
						<form:option value="-1" label="--Select--" />
						<form:options itemLabel="name" itemValue="id" items="${priorities}" />
					</form:select>
				</td>
				<td><form:errors path="priority" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Status:</th>
				<td>
					<form:select path="status">
						<form:option value="" label="--Select--" />
						<form:options itemLabel="name" itemValue="code" items="${statuses}" />
					</form:select>
				</td>
				<td><form:errors path="status" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Wplyw:</th>
				<td>
					<form:select path="impact">
						<form:option value="" label="--Select--" />
						<form:options itemLabel="name" itemValue="code" items="${impacts}" />
					</form:select>
				</td>
				<td><form:errors path="impact" cssClass="error" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Komentarze</legend>
		<table>
			<c:forEach items="${comments}" var="comment">
			<tr>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${comment.creationDate}" /></td>
				<td>${comment.text}</td>
			</tr>
			</c:forEach>
		</table>
		<button onclick="javascript:window.open('comment?requestId=${request.id}', 'Nazwa okna','width=400,height=200'); return false;">Dodaj komentarz</button> 
	</fieldset>
	<div id="buttonGroup">
		<input type="submit" value="Save" />
	</div>
</form:form>


<form:form modelAttribute="comment" action="addcomment" method="post">
	<table>
			<tr>
				<th>Komentarz:</th>
				<td><form:input path="text" /></td>
				<td><form:errors path="text" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>
	</table>
</form:form>

<form:form modelAttribute="helper" action="test" method="post">
<fieldset>
		<legend>Incydenty</legend>
		<table>
			<tr>
				<td><form:checkbox path="incidents" value="i1"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:checkbox path="incidents" value="i2"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:checkbox path="incidents" value="i3"></form:checkbox></td>
			</tr>
			<tr>
				<td><input type="submit" value="zapisz" /></td>
			</tr>
		</table>
	</fieldset>
</form:form>	