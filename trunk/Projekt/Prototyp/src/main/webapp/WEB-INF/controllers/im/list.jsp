<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Incidents:</h1>

<c:if test="${empty incidents}">
	No hotels found
</c:if>

<c:if test="${not empty incidents}">
	<ul>
		<c:forEach items="${incidents}" var="incident">
			<li>
				<a href="<c:url value="/app/im/details?id=${incident.id}" />">
					<c:out value="${incident.description}" />
				</a>
			</li>
		</c:forEach>
	</ul>
</c:if>
