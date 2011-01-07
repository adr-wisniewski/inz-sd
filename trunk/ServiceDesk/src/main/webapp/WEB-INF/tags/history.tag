<%@ tag body-content="empty" description="Historia" %>
<%@ attribute name="actionsList" required="true" type="java.util.List" description="lista akcji"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<fieldset>
	<legend><spring:message code="history.label"/></legend>
	
	<div id="tabs">
	<ul>
		<li><a href="#tabs-1">1</a></li>
		<li><a href="#tabs-2">2</a></li>
	</ul>
	<div id="tabs-1">
	<c:forEach items="${actionsList}" var="actions">
		<span class="date">${actions.eventDate}, ${actions.employee.name}</span>
		<hr />
		
		<ol>
		<c:forEach items="${actions.actions}" var="a">
			<li>
				<strong><spring:message code="${a.actionType.descriptionCode}"/>:</strong> ${a.beforeValue} <c:out value="->"/>  ${a.afterValue}
			</li>
		</c:forEach>
		</ol>
	</c:forEach>
	</div>
	<div id="tabs-2">
	<table class="tablesorter">
		<thead>
			<tr>
				<th><spring:message code="change_date.history"/></th>
				<th><spring:message code="author.history"/></th>
				<th><spring:message code="action_type.history"/></th>
				<th><spring:message code="before.history"/></th>
				<th><spring:message code="after.history"/></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${actionsList}" var="actions">
			<c:forEach items="${actions.actions}" var="a">
				<tr>
					<td>${actions.eventDate}</td>
					<td>${actions.employee.name}</td>
					<td><spring:message code="${a.actionType.descriptionCode}"/></td>
					<td>${a.beforeValue}</td>
					<td>${a.afterValue}</td>
				</tr>
			</c:forEach>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</fieldset>


<script type="text/javascript">
$(function() {
	$("#tabs").tabs();
});
</script>