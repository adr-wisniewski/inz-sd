<%@ tag body-content="empty" description="Drzewo" %>
<%@ attribute name="item" required="true" description="Element hierarchii" type="servicedesk.core.base.tree.domain.TreeItem"%>
<%@ attribute name="url" required="true" description="adres URL"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<li<c:if test="${item.open}"> class="open"</c:if>>
        <a href="<c:url value="${url}?id=${item.id}"/>" class="standard_link">
                <c:choose>
                        <c:when test="${item.current}"><span class="current_item">${item.name}</span></c:when>
                        <c:otherwise>${item.name}</c:otherwise>
                </c:choose>
        </a>

	<c:if test="${not empty item.childs}">
		<sd:tree roots="${item.childs}" url="${url}" />
	</c:if>
</li>