<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@attribute name="object" required="true" rtexprvalue="true" type="servicedesk.cmdb.domain.Item" %>

<print:nullable object="${object}">
    <a class="item" href="/cmdb/item/${object.id}">
            ${object.id}
    </a>
</print:nullable>