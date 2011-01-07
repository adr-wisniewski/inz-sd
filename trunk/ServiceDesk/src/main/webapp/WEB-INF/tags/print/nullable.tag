<%-- 
    Document   : valueempty
    Created on : 2010-11-10, 13:52:45
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="object" required="true" rtexprvalue="true" type="java.lang.Object"%>

<c:choose>
    <c:when test="${object != null}">
        <jsp:doBody />
    </c:when>
    <c:otherwise>
        <spring:message code="null" />
    </c:otherwise>
</c:choose>