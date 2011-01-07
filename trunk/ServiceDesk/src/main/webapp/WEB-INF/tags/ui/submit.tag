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

<c:set var="nameattr">
    <c:if test="${name != null}">
        name="${name}"
    </c:if>
</c:set>

<c:set var="valueattr">
    <c:if test="${value != null}">
        value="${value}"
    </c:if>
</c:set>

<button type="submit" ${nameattr} ${valueattr} class="${cssClass}">
    <span>
        <spring:message code="${code}" />
    </span>
</button>