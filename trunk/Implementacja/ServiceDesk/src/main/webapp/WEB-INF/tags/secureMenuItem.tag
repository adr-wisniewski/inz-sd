<%@ tag body-content="empty" description="Element menu wyświetlany, gdy zalogowany użytkownik posiada odpowiednie uprawnienia" %>
<%@ attribute name="url" required="true" description="Adres url" %>
<%@ attribute name="code" required="true" description="Kod etykiety" %>
<%@ attribute name="privilege" required="true" description="Wymagane uprawnienia użytkownika" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize ifAnyGranted="${privilege}">		
<li><a href="<c:url value="${url}" />"><spring:message code="${code}" /></a></li>
</security:authorize>