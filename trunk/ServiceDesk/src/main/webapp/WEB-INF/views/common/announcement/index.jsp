<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:announcements announcements="${announcements}">
    <jsp:attribute name="buttons">
        <ui:actionButton label="edit.label" cssClass="edit">
            <jsp:attribute name="action">
                <spring:url value="/common/announcement/{id}/edit">
                    <spring:param name="id">${announcement.id}</spring:param>
                </spring:url>
            </jsp:attribute>
        </ui:actionButton>
        <ui:actionButton label="delete.label" cssClass="delete">
            <jsp:attribute name="action">
                <spring:url value="/common/announcement/{id}/delete">
                    <spring:param name="id">${announcement.id}</spring:param>
                </spring:url>
            </jsp:attribute>
        </ui:actionButton>
    </jsp:attribute>
    <jsp:attribute name="bottom">
        <p class="buttons">
            <ui:actionButton label="add.label" cssClass="add" action="/common/announcement/add" />
        </p>
    </jsp:attribute>
</ui:announcements>

    


