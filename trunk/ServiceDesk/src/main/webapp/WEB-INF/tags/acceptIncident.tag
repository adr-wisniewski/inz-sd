<%-- 
    Document   : acceptIncident
    Created on : 2010-08-25, 00:01:09
    Author     : Piotrek Kalanski
--%>

<%@tag description="Link do przypisania incydentu" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="incident" type="sd.im.domain.Incident" %>

<%-- any content can be specified here e.g.: --%>
<security:authorize ifAnyGranted="ACCEPT_IM">
<a href="<c:url value="/im/accept?id=${incident.id}" />" class="button"><spring:message code="accept.label" /></a>
</security:authorize>