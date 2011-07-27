<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="caption.change.rfc.priority.list">
    <table class="tablesorter priorities">
        <thead>
            <tr>
                <th class="fit"><spring:message code="field.change.rfc.priority.id" /></th>
                <th><spring:message code="field.change.rfc.priority.name" /></th>
                <th><spring:message code="field.change.rfc.priority.urgent" /></th>
                <th><spring:message code="field.change.rfc.priority.order" /></th>
                <th class="fit noSort"><spring:message code="caption.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${priorities}" var="priority">
                <tr>
                    <td>
                        ${priority.id}
                    </td>
                    <td>
                        ${priority.name}
                    </td>
                    <td>
                        <print:yesorno value="${priority.urgent}" />
                    </td>
                    <td>
                        ${priority.order}
                    </td>
                    <td class="actions">
                        <ui:actionButton label="details.label"
                            action="/change/rfc/priority/${priority.id}"
                            cssClass="details"/>
                        <ui:actionButton label="edit.label"
                            action="/change/rfc/priority/${priority.id}/edit"
                            cssClass="edit"/>
                        <ui:actionButton label="delete.label"
                            action="/change/rfc/priority/${priority.id}/delete"
                            cssClass="delete"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p class="buttons">
        <ui:actionButton label="add.label" cssClass="add" action="/change/rfc/priority/add" />
    </p>
</ui:panel>