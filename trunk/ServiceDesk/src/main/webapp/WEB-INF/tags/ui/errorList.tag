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
<%@attribute name="fieldPrefix" required="true" %>


<spring:hasBindErrors name="${requestScope['org.springframework.web.servlet.tags.form.AbstractFormTag.modelAttribute']}">
    <ui:errorBox caption="form.errors">
        <ul>
            <c:forEach items="${errors.globalErrors}" var="globalError">
                <li><spring:message code="${globalError.code}" /></li>
            </c:forEach>
            <c:forEach items="${errors.fieldErrors}" var="error">
                <li>
                    <strong>
                        <spring:message code="${fieldPrefix}.${error.field}" />: 
                    </strong>
                    <spring:message code="${error.code}" />
                </li>
            </c:forEach>    
        </ul>    
    </ui:errorBox>    
</spring:hasBindErrors>
<%--
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
--%>