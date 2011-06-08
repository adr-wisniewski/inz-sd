<%-- 
    Document   : panel
    Created on : 2010-11-17, 13:20:41
    Author     : Adrian
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="caption" required="true" %>
<%@attribute name="captionArgs" required="false" rtexprvalue="true" %>
<%@attribute name="cssClass" required="false" %>

<div class="element panel ${cssClass}">
    <h1 class="caption">
        <spring:message code="${caption}" arguments="${captionArgs}"/>
    </h1>
    <div class="content">
        <jsp:doBody/>
    </div>
</div>
