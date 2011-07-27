<%-- 
    Document   : actionButton
    Created on : 2010-12-10, 12:15:40
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action" rtexprvalue="true" required="true"%>
<%@attribute name="label" rtexprvalue="true" required="true"%>
<%@attribute name="cssClass" rtexprvalue="true" required="false"%>
<%@attribute name="disabled" rtexprvalue="true" required="false" type="java.lang.Boolean"%>
<%@attribute name="role" rtexprvalue="true" required="false"%>

<c:if test="${not empty role}">
    <c:set var="authorized" value="${false}" />
    <security:authorize ifAnyGranted="${role}">
        <c:set var="authorized" value="${true}" />
    </security:authorize>
</c:if>

<c:set var="cssClass">
    action ${pageScope.cssClass} <c:if test="${authorized == false}">unauthorized</c:if>
</c:set>


<a href="${pageScope.action}" class="action ${pageScope.cssClass}">
    <button type="button" class="action ${pageScope.cssClass}" <c:if test="${authorized == false or disabled}">disabled="disabled"</c:if>>
        <span>
            <spring:message code="${pageScope.label}" />
        </span>
    </button>
</a>
