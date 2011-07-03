<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@attribute name="object" required="true" rtexprvalue="true" type="servicedesk.core.itil.cmdb.domain.EntityClass" %>

<print:nullable object="${object}">
    <spring:eval var="link" expression="@entityClassLinkVisitor.process(object)" />
    <a class="entityclass" href="${link}">
            ${object.name}
    </a>
</print:nullable>
