<%@ tag body-content="empty" description="Drzewo" %>
<%@ attribute name="roots" required="true" description="Korzenie" type="java.util.List"%>
<%@ attribute name="urlFormat" required="true" description="adres URL"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<ul>
    <c:forEach items="${roots}" var="i">
        <sd:treeItem item="${i}" urlFormat="${urlFormat}"/>
    </c:forEach>
</ul>