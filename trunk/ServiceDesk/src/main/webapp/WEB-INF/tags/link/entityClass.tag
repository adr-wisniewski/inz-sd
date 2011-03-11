<%--
    Document   : itemClass
    Created on : 2010-11-22, 15:32:24
    Author     : Adrian
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@attribute name="object" required="true" rtexprvalue="true" type="sd.cmdb.domain.EntityClass" %>

<print:nullable object="${object}">
    <spring:eval var="link" expression="T(sd.cmdb.web.EntityClassLinkVisitor).process(object)" />
    <a class="entityclass" href="${link}">
            ${object.name}
    </a>
</print:nullable>
