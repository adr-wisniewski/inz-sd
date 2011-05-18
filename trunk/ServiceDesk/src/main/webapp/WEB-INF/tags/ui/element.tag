<%-- 
    Document   : element
    Created on : 2010-12-22, 18:20:04
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="cssClass" required="false" %>


<div class="element ${cssClass}">
    <jsp:doBody/>
</div>