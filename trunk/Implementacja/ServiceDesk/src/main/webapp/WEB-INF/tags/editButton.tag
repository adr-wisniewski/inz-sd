<%@ tag body-content="empty" description="Button z ikonka do edycji" %>
<%@ attribute name="url" required="true" description="Fragment adresu URL. Zostanie przekazany tagowi c:url" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="${url}" />"><img style="border: none;" alt="Edit" src="<c:url value="/static/images/edit.gif" />"></a>