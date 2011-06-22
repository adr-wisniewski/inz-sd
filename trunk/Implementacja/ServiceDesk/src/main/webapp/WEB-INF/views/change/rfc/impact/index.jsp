<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="caption.change.rfc.impact.list">
    <table class="impacts tablesorter">
        <thead>
            <tr>
                <th class="fit"><spring:message code="field.change.rfc.impact.id" /></th>
                <th><spring:message code="field.change.rfc.impact.name" /></th>
                <th><spring:message code="field.change.rfc.impact.order" /></th>
                <th class="fit noSort"><spring:message code="caption.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${impacts}" var="impact">
                <tr>
                    <td>
                        ${impact.id}
                    </td>
                    <td>
                        ${impact.name}
                    </td>
                    <td>
                        ${impact.order}
                    </td>
                    <td class="actions">
                        <ui:actionButton label="details.label"
                            action="/change/rfc/impact/${impact.id}"
                            cssClass="details"/>
                        <ui:actionButton label="edit.label"
                            action="/change/rfc/impact/${impact.id}/edit"
                            cssClass="edit"/>
                        <ui:actionButton label="delete.label"
                            action="/change/rfc/impact/${impact.id}/delete"
                            cssClass="delete"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p class="buttons">
        <ui:actionButton label="add.label" cssClass="add" action="/change/rfc/impact/add" />
    </p>
</ui:panel>