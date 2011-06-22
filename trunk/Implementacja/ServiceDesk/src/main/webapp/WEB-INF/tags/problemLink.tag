<%@ tag body-content="empty" description="Link do karty problemu" %>
<%@ attribute name="label" required="true" description="Etykieta do wyswietlenia" %>
<%@ attribute name="id" required="true" type="java.lang.Integer" description="identyfikator incydentu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="/pm/edit?id=${id}" />" class="standard_link">${label}</a>
	