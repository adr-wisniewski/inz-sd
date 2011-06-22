<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="signal_types.label" /></div>


<table class="tablesorter">
	<thead>
		<tr>
			<th>Id</th>
			<th><spring:message code="name.label" /></th>
			<th><spring:message code="object_type.label" /></th>
			<th><spring:message code="signal_significance.label" /></th>
			<th><spring:message code="signal_subject_template.label" /></th>
			<th><spring:message code="signal_message_template.label" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${signal_types}" var="s">
		<tr>
			<td>${s.code}</td>
			<td>${s.name}</td>
			<td>${s.objectType.code}</td>
			<td>${s.significance.name}</td>
			<td>${s.messageTemplate}</td>
			<td>${s.subjectTemplate}</td>
			<td><sd:editButton url="/signal/edittype?code=${s.code}"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

