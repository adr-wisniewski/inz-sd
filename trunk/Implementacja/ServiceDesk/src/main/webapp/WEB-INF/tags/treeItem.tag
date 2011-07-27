<%@ tag body-content="empty" description="Drzewo" %>
<%@ attribute name="item" required="true" description="Element hierarchii" type="servicedesk.web.base.tree.domain.TreeItem"%>
<%@ attribute name="urlFormat" required="true" description="adres URL"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" uri="/WEB-INF/util.tld" %>

<c:set var="itemContent">
    ${item.value.name}
</c:set>

<c:if test="${item.selected}">
    <c:set var="itemContent">
        <span class="current_item">${itemContent}</span>
    </c:set>
</c:if>

<li<c:if test="${item.open}"> class="open"</c:if>>
    <c:choose>
        <c:when test="${item.disabled}">
            <span class="disabled">
                ${itemContent}
            </span>
        </c:when>
        <c:otherwise>
            <a href="${util:format(urlFormat, item.value.id)}" class="standard_link">
                ${itemContent}
            </a>
        </c:otherwise>
    </c:choose>
    
    <c:if test="${not empty item.children}">
        <sd:tree roots="${item.children}" urlFormat="${urlFormat}" />
    </c:if>
</li>