<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>

<ui:panel caption="caption.cmdb.relationship.pickclass">
    <ui:listView items="${classes}">
        <jsp:attribute name="label">
            <a href="/cmdb/relationship//addForItem/${origin.id}/${item.id}"><c:out value="${item.name}"/></a>
        </jsp:attribute>
    </ui:listView>
</ui:panel>
