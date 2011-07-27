<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element>
    <ul>
        <li>
            <a href="/cmdb/item/class/add">
                <spring:message code="action.cmdb.item.class.add"/>
            </a>
        </li>
        <li>
            <a href="/cmdb/item/class/browse">
                <spring:message code="action.cmdb.item.class.browse"/>
            </a>
        </li>
        <li>
            <a href="/cmdb/item/class/search">
                <spring:message code="action.cmdb.item.class.search"/>
            </a>
        </li>
    </ul>
</ui:element>

