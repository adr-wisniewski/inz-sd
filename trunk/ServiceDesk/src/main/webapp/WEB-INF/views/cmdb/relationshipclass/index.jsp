<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element>
    <ul>
        <li>
            <a href="/cmdb/relationship/class/add">
                <spring:message code="action.cmdb.relationship.class.add"/>
            </a>
        </li>
        <li>
            <a href="/cmdb/relationship/class/browse">
                <spring:message code="action.cmdb.relationship.class.browse"/>
            </a>
        </li>
        <li>
            <a href="/cmdb/relationship/class/search">
                <spring:message code="action.cmdb.relationship.class.search"/>
            </a>
        </li>
    </ul>
</ui:element>

