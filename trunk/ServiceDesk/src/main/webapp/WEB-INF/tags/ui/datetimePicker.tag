<%@ tag body-content="empty" description="Kontrolka do wyboru daty" %>
<%@ attribute name="name" required="true" description="Nazwa kontrolki"%>
<%@ attribute name="value" required="true" description="Wartosc kontrolki" type="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<c:set var="formatted">
    <print:datetime datetime="${value}" wrap="false" />
</c:set>

<input class="datetime" type="text" id="${name}" name="${name}" value="${formatted}" readonly="readonly" />

<script type="text/javascript">
	$(function() {
		$("#${name}").datetimepicker({
                    <c:if test="${not empty value}">
                        hour: <spring:eval expression="value.getHours()" />,
                        minute: <spring:eval expression="value.getMinutes()" />,
                    </c:if>
                });
	});
</script>