<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="treepicker.caption">
    <sd:treeView roots="${roots}" url="/servicedesk/treePickerChoose" />
    <a href="/servicedesk/treePickerChoose?id=null" class="standard_link"><spring:message code="nonepick.label" /></a>
    | <a href="#" class="standard_link" onclick="window.close(); return false;"><spring:message code="cancel.label" /></a>
</ui:panel>