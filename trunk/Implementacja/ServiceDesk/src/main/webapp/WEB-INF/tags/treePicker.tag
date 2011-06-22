<%@ tag body-content="empty" description="Kontrolka do wyboru elementu hierarchii. Patrz servicedesk.core.base.tree.*" %>
<%@ attribute name="name" required="true" description="Nazwa kontrolki"%>
<%@ attribute name="source" required="true" description="Nazwa zrodla danych"%>
<%@ attribute name="value" required="true" type="servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject<? extends java.io.Serializable>" description="wartosc kontrolki" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	function pickItem(href, elementId) {
		var value = document.getElementById(elementId).value;
		window.open(href + value, 'Tree', 'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes,fullscreen=yes,channelmode=no, width=600,height=400').focus();
	}
</script>

<c:url value="/servicedesk/treePicker" var="url">
    <c:param name="name" value="${name}" />
    <c:param name="source" value="${source}" />
    <c:param name="value" value="" />
</c:url>

<input type="hidden" id="${name}" name="${name}" value="${value.id}" />
<input class="picker" type="text" value="${value.name}" id="treePicker-${name}" onclick="pickItem('${url}', '${name}');" readonly="readonly" />