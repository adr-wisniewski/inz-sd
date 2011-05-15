<%@ tag body-content="empty" description="Kontrolka do wyboru daty" %>
<%@ attribute name="name" required="true" description="Nazwa kontrolki"%>
<%@ attribute name="value" required="true" description="Wartosc kontrolki" type="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<input type="text" id="${name}" name="${name}" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${value}" />" readonly="readonly" />

<script type="text/javascript">
	$(function() {
		$("#${name}").datepicker($.datepicker.regional['pl']);
	});
</script>