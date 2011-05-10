<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ attribute name="change" required="true" rtexprvalue="true" type="servicedesk.infrastructure.general.domain.HistoryRecord"%>

 <div class="rfc change">
    <span class="author">
        <link:employee object="${change.revison.instigator}" />
        <print:datetime datetime="${change.revison.timestamp}" />
    </span>
    
    <c:choose>
        <c:when test="${empty change.previous}">
            
        </c:when>
    </c:choose>
    
    
    
    <span class="signarure">
        <link:employee object="${entry.creator}"/> <print:datetime datetime="${entry.timestamp}" />
    </span>
</div>