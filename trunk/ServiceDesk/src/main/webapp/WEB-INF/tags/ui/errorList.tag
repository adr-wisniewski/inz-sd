<%-- 
    Document   : errorList
    Created on : 2010-11-23, 15:39:10
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<form:errors path="*">
    <c:if test="${not empty messages}">
        <ui:errorBox caption="form.errors">
            <ul>
                <c:forEach items="${messages}" var="message">
                    <li>${message}</li>
                </c:forEach>
            </ul>
        </ui:errorBox>
    </c:if>
</form:errors>