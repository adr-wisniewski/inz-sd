<%@ tag body-content="empty" description="Drzewo. UWAGA!!! W aktualnej wersji na stronie moze byc tylko jedna taka kontrolka!!!" %>
<%@ attribute name="roots" required="true" description="Korzenie" type="java.util.List"%>
<%@ attribute name="urlFormat" required="true" description="adres URL"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<div id="treecontrol">
    <a href="?#" class="standard_link">
        <spring:message code="collapse.all" />
    </a>
    |
    <a href="?#" class="standard_link">
        <spring:message code="expand.all" />
    </a>
</div>

<ul id="treepicker" class="treeview-black <c:if test="${empty roots}">empty</c:if>">
    <c:forEach items="${roots}" var="i">
        <sd:treeItem item="${i}" urlFormat="${urlFormat}"/>
    </c:forEach>
    <c:if test="${empty roots}">
        <spring:message code="null" />
    </c:if>
</ul>

<script type="text/javascript">
    $(document).ready(function(){
        $("#treepicker").treeview({
            animated: "medium",
            collapsed: true,
            control:"#treecontrol"
        });
    });
</script>




