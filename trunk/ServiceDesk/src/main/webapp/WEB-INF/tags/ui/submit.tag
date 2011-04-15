<%-- 
    Document   : submit
    Created on : 2010-11-24, 15:41:50
    Author     : Adrian
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="code" required="true" rtexprvalue="true"%>
<%@attribute name="name" required="false"%>
<%@attribute name="value" required="false" rtexprvalue="true"%>
<%@attribute name="cssClass" required="false" rtexprvalue="true"%>
<%@attribute name="disabled" rtexprvalue="true" required="false" type="java.lang.Boolean"%>

<c:set var="nameattr">
    <c:if test="${pageScope.name != null}">
        name="${pageScope.name}"
    </c:if>
</c:set>

<c:set var="valueattr">
    <c:if test="${pageScope.value != null}">
        value="${pageScope.value}"
    </c:if>
</c:set>

<button <c:if test="${disabled == true}">disabled="disabled"</c:if> type="submit" ${pageScope.nameattr} ${pageScope.valueattr} class="${pageScope.cssClass}">
    <span>
        <spring:message code="${pageScope.code}" />
    </span>
</button>