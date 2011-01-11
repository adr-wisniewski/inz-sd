<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="code" required="false" description="Kod wiadomosci"%>
<%@attribute name="label" required="false" description="Kod wiadomosci"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="label_text">
    <c:if test="${code != null}">
        <spring:message code="${code}" />
    </c:if>
</c:set>

<c:if test="${label}">
    <c:set var="label_text">
        <label for="${label}">
            ${label_text}
        </label>
    </c:set>
</c:if>

<tr>
    <th>
        ${label_text}
    </th>
    <td>
        <jsp:doBody/>
    </td>
</tr>