<%@ tag body-content="empty" description="Kontrolka do wyboru przedzialu dat" %>
<%@ attribute name="nameFrom" required="true" description="Nazwa dla daty od"%>
<%@ attribute name="nameTo" required="true" description="Nazwa dla daty do"%>
<%@ attribute name="valueFrom" required="true" description="Wartosc daty od" type="java.util.Date"%>
<%@ attribute name="valueTo" required="true" description="Wartosc daty do" type="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<spring:message code="from.label"/>: 
<input type="text" id="${nameFrom}" name="${nameFrom}" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${valueFrom}" />" readonly="readonly" />
<br />
<spring:message code="to.label"/>: 
<input type="text" id="${nameTo}" name="${nameTo}" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${valueTo}" />" readonly="readonly" />

<script type="text/javascript">
	$(function() {
		$("#${nameFrom}, #${nameTo}").datepicker($.datepicker.regional['pl']);
	});
</script>