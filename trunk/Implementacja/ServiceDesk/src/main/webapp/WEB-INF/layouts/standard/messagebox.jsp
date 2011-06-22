<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${not empty messages}">
    <ui:panel caption="messages.arrived" cssClass="success">
        <ul class="messages">
            <c:forEach var="message" items="${messages}">
                <li>${message}</li>
            </c:forEach>
        </ul>

        <!-- TODO: add close button -->
        <p class="close">
            <a href="" onclick="$(this).closest('.panel').slideUp(); return false">
                <spring:message code="sd.messagebox.close" />
            </a>
        </p>
    </ui:panel>
</c:if>