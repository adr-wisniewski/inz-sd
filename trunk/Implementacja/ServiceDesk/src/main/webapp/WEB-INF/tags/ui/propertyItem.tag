<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="code" required="false" rtexprvalue="true" description="Kod wiadomosci"%>
<%@attribute name="caption" required="false" rtexprvalue="true" description="Kod wiadomosci"%>
<%@attribute name="label" required="false" rtexprvalue="true" description="Kod wiadomosci"%>
<%@attribute name="cssClass" required="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="label_text">
    <c:if test="${code != null}">
        <spring:message code="${code}" />
    </c:if>
    <c:if test="${caption != null}">
        ${caption}
    </c:if>
</c:set>

<c:if test="${label != null}">
    <c:set var="label_text">
        <label for="${label}">
            ${label_text}
        </label>
    </c:set>
</c:if>

<tr class="${cssClass}">
    <th>
        ${label_text}
    </th>
    <td>
        <jsp:doBody/>
    </td>
</tr>