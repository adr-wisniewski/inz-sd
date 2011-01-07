<%--
    Document   : menuItem
    Created on : 2010-10-02, 14:22:13
    Author     : Adrian
--%>

<%@tag description="main menu composite item" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="url" required="true" %>
<%@attribute name="name" required="true" %>
<%@attribute name="name_args" required="false" %>
<%@attribute name="icon" required="false" %>

<jsp:doBody var="body" />
<c:set var="body" value="${fn:trim(body)}"/>


<c:if test="${not empty body}">
    <li>
        <a href="<c:url value="${url}" />" class="${icon}">
            <spring:message arguments="${name_args}" code="${name}" />
        </a>

        <ul>
            ${body}
        </ul>
    </li>
</c:if>