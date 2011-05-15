<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="caption.change.rfc.resolution.list">
    <table class="resolutions tablesorter">
        <thead>
            <tr>
                <th class="fit"><spring:message code="field.change.rfc.resolution.id" /></th>
                <th><spring:message code="field.change.rfc.resolution.name" /></th>
                <th><spring:message code="field.change.rfc.resolution.order" /></th>
                <th class="fit noSort"><spring:message code="caption.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${resolutions}" var="resolution">
                <tr>
                    <td>
                        ${resolution.id}
                    </td>
                    <td>
                        ${resolution.name}
                    </td>
                    <td>
                        ${resolution.order}
                    </td>
                    <td class="actions">
                        <ui:actionButton label="details.label"
                            action="/change/rfc/resolution/${resolution.id}"
                            cssClass="details"/>
                        <ui:actionButton label="edit.label"
                            action="/change/rfc/resolution/${resolution.id}/edit"
                            cssClass="edit"/>
                        <ui:actionButton label="delete.label"
                            action="/change/rfc/resolution/${resolution.id}/delete"
                            cssClass="delete"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p class="buttons">
        <ui:actionButton label="add.label" cssClass="add" action="/change/rfc/resolution/add" />
    </p>
</ui:panel>