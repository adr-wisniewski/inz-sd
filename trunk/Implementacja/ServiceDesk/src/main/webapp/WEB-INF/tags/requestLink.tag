<%@ tag body-content="empty" description="Link do karty requestu" %>
<%@ attribute name="label" required="true" description="Etykieta do wyswietlenia" %>
<%@ attribute name="id" required="true" type="java.lang.Integer" description="identyfikator requestu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="/rf/edit?id=${id}" />" class="standard_link">${label}</a>
	