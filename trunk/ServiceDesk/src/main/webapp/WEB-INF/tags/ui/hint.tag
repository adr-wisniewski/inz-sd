<%-- 
    Document   : hint
    Created on : 2010-10-19, 18:50:16
    Author     : Adrian
--%>

<%@tag description="hint panel" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<%@attribute name="code" required="true"%>

<ui:panel caption="ui.caption.hint" cssClass="hint">
    <p>
        <spring:message code="${code}" />
    </p>
</ui:panel>