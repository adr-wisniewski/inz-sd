<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@attribute name="object" required="true" rtexprvalue="true" type="servicedesk.core.itil.change.domain.entity.RfcAuthority" %>

<print:nullable object="${object}">
    <a class="item" href="/change/rfc/authority/${object.id}">
            ${object.name}
    </a>
</print:nullable>