<%-- 
    Document   : menuGroup
    Created on : 2010-10-02, 13:51:58
    Author     : Adrian
--%>
<%@tag description="group of menu items" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="name" required="true" %>
<%@attribute name="id" required="true" %>

<jsp:doBody var="body" />

<c:if test="${not empty body}">
    <div id="${id}" class="menuGroup">
        <h5 class="collapsible"><spring:message code="${name}" /></h5>
        <ul>
            ${body}
        </ul>
    </div>
</c:if>

