<%-- 
    Document   : actionButton
    Created on : 2010-12-10, 12:15:40
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action" rtexprvalue="true" required="true"%>
<%@attribute name="label" rtexprvalue="true" required="true"%>
<%@attribute name="cssClass" rtexprvalue="true" required="false"%>

<form action="${action}" method="get" class="actionButtonForm">
    <ui:submit code="${label}" cssClass="${cssClass}" />
</form>