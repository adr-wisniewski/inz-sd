<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ attribute name="notifications" required="true" rtexprvalue="true" type="java.util.Collection" %>

<ui:panel caption="caption.common.notification.list" cssClass="notifications">
    <table class="tablesorter notifications">
        <thead>
            <tr>
                <th>
                    <spring:message code="caption.common.notification.text" />
                </th>
                <th>
                    <spring:message code="caption.common.notification.instigator" />
                </th>
                <th>
                    <spring:message code="caption.common.notification.time" />
                </th>
                <th class="fit noSort">
                    <spring:message code="actions" />
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${notifications}" var="notification">
                <c:set var="rowCssClass" value="${notification.visited ? 'visited' : 'unvisited'}" />
                <tr class="${rowCssClass}">
                <td>
                    <spring:eval expression="notification.accept(@notificationTextResolver, null)" />
                </td>
                <td>
                    <link:user object="${notification.instigator}" />
                </td>
                <td>
                    <print:datetime datetime="${notification.timestamp}" />
                </td>
                <td class="actions">
                    <ui:actionButton action="/common/notification/${notification.id}/visit" 
                                 label="caption.common.notification.visit" 
                                 cssClass="goto" />
                    <ui:actionButton action="/common/notification/${notification.id}/delete" 
                                     label="delete.label" 
                                     cssClass="delete" />
                </td>
            </tr>
            </c:forEach>
            <c:if test="${empty notifications}">
                <tr>
                    <td colspan="4">
                        <spring:message code="caption.common.notification.empty" />
                    </td>
                </tr>
            </c:if>
        </tbody>
    </table>
</ui:panel>