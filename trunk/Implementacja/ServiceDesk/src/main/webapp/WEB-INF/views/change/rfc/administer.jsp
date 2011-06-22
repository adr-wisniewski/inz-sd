<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element>
    <ul>
        <li>
            <a href="/change/rfc/priority">
                <spring:message code="action.change.rfc.priority"/>
            </a>
        </li>
        <li>
            <a href="/change/rfc/impact">
                <spring:message code="action.change.rfc.impact"/>
            </a>
        </li>
        <li>
            <a href="/change/rfc/category">
                <spring:message code="action.change.rfc.category"/>
            </a>
        </li>
    </ul>
</ui:element>

