<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element>
    <ul>
        <security:authorize ifAnyGranted="CHANGE_RFC_ADD">
        <li>
            <a href="/change/rfc/created">
                <spring:message code="action.change.rfc.created"/>
            </a>
        </li>
        </security:authorize>
        <li>
            <a href="/change/rfc">
                <spring:message code="action.change.rfc"/>
            </a>
        </li>
    </ul>
</ui:element>

