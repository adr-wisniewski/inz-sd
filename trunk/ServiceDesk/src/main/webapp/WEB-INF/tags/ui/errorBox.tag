<%-- 
    Document   : errorPanel
    Created on : 2010-12-10, 17:00:31
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="caption" required="true"%>

<div class="errorBox">
    <h2><spring:message code="${caption}" /></h2>
    <jsp:doBody />
</div>