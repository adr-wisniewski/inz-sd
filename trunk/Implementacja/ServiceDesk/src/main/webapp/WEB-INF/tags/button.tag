<%@ tag body-content="empty" description="Button z komenda na karcie zdarzenia" %>
<%@ attribute name="url" required="true" description="Fragment adresu URL. Zostanie przekazany tagowi c:url" %>
<%@ attribute name="code" required="true" description="Kod wiadomosci"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<input type="button" value="<spring:message code="${code}" />" onclick="location.href='<c:url value="${url}" />'" />
	