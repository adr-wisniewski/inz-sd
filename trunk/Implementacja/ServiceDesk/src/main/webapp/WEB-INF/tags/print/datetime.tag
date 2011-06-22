<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="datetime" required="true" rtexprvalue="true" type="java.util.Date"%>
<%@ attribute name="wrap" rtexprvalue="true" required="false" type="java.lang.Boolean"%>

<c:if test="${empty wrap}">
    <span class="datetime">
</c:if>
        
<fmt:formatDate value="${datetime}" type="both" pattern="MM/dd/yyyy HH:mm" />
<c:if test="${empty wrap}">
    </span>
</c:if>
