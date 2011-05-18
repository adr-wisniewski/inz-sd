<%@ tag body-content="empty" description="Link do szczegolow grupy" %>
<%@ attribute name="group" required="true" description="grupa" type="servicedesk.core.itil.im.domain.SupportGroup" %>
<%@ attribute name="label" description="Etykieta. Gdy brak, etykiety to bedzie to nazwa grupy." %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="/servicedesk/groupDetails?id=${group.id}" />" class="standard_link">
<c:choose>
	<c:when test="${empty label}">${group.name}</c:when>
	<c:otherwise>${label}</c:otherwise>
</c:choose>
</a>
	