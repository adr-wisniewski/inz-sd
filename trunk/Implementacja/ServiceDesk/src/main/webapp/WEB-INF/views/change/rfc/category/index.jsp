<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="caption.change.rfc.category.tree">
    <sd:treeView roots="${categories}" urlFormat="/change/rfc/category/%s"/>
    <p class="buttons">
        <ui:actionButton label="add.label" cssClass="add" action="/change/rfc/category/add" />
    </p>
</ui:panel>