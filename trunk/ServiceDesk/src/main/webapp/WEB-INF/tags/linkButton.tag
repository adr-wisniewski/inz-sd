<%@ tag body-content="empty" description="Button z odnosnikiem" %>
<%@ attribute name="url" required="true" description="Fragment adresu URL. Zostanie przekazany tagowi c:url" %>
<%@ attribute name="label" required="true" description="Etykieta" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a class="button" href="<c:url value="${url}" />">${label}</a>