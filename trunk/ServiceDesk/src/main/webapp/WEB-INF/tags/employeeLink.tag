<%@ tag body-content="empty" description="Link do szczegolow pracownika" %>
<%@ attribute name="employee" required="true" description="Pracownika" type="servicedesk.domain.Employee" %>
<%@ attribute name="label" description="Etykieta do wyswietlenia. Domyslnie imie i nazwisko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="/servicedesk/employeeDetails?id=${employee.id}" />" class="standard_link">
<c:choose>
	<c:when test="${empty label}">${employee.name}</c:when>
	<c:otherwise>${label}</c:otherwise>
</c:choose>
</a>
	