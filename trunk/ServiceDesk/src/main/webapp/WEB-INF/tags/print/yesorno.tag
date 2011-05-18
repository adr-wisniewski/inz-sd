<%-- 
    Document   : yesno
    Created on : 2010-11-10, 13:50:24
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="value" required="true" rtexprvalue="true" type="java.lang.Boolean"%>

<c:choose>
    <c:when test="${value}">
          <spring:message code="Yes" />
    </c:when>
    <c:otherwise>
        <spring:message code="No" />
    </c:otherwise>
</c:choose>