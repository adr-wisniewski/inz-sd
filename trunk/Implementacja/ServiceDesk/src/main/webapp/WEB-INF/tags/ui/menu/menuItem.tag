<%-- 
    Document   : menuItem
    Created on : 2010-10-02, 14:22:13
    Author     : Adrian
--%>

<%@tag description="main menu item" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="url" required="true" %>
<%@attribute name="name" required="true" %>
<%@attribute name="name_args" required="false" %>
<%@attribute name="role" required="false" %>
<%@attribute name="icon" required="false" %>

<%-- Tag body --%>
<c:set var="body">
     <li>
        <a href="<c:url value="${url}" />" class="${icon}">
            <spring:message arguments="${name_args}" code="${name}" />
        </a>
    </li>
</c:set>


<c:choose>
    <c:when test="${role != null}">
        <security:authorize ifAnyGranted="${role}">
            ${body}
        </security:authorize>
    </c:when>
    <c:otherwise>
        ${body}
    </c:otherwise>
</c:choose>
