<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@attribute name="object" required="true" rtexprvalue="true" type="servicedesk.domain.Employee" %>

<print:nullable object="${object}">
    <a class="employee" href="http://localhost:8084/servicedesk/employeeDetails?id=${object.id}">
        ${object.firstname} ${object.lastname}
    </a>
</print:nullable>
