<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="caption.cmdb.item.class.overview" cssClass="overview">
    <h1><spring:message code="caption.cmdb.item.class.parent"/></h1>
    <p>
        <link:itemsByClass object="${itemClass.parent}" />
    </p>
    
    <h1><spring:message code="caption.cmdb.item.class.children"/></h1>
    <p>
        <print:nullable object="${itemClass.children}">
            <c:forEach items="${itemClass.children}" var="child">
                <link:itemsByClass object="${child}" />
            </c:forEach>
        </print:nullable>
    </p>

    <h1><spring:message code="caption.cmdb.item.class.description"/></h1>
    <p>
        <c:out value="${itemClass.description}" />
    </p>
</ui:panel>

<ui:panel caption="caption.cmdb.item.items">
    <table class="tablesorter">
        <thead>
            <tr>
                <th><spring:message code="field.cmdb.item.class" /></th>
                <th><spring:message code="field.cmdb.item.label" /></th>
                <th><spring:message code="field.cmdb.item.overview" /></th>
                <th class="actions2"><spring:message code="caption.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>
                        <c:out value="${item.itemClass.name}" />
                    </td>

                    <td>
                        <c:out value="${item.label}" />
                    </td>

                    <td>
                        <c:out value="${item.overview}" />
                    </td>
                    
                    <td class="actions2">
                        <ui:actionButton label="details.label"
                             action="/cmdb/item/${item.id}"
                             cssClass="details"/>

                        <ui:actionButton label="delete.label"
                             disabled="${readOnly}"
                             action="/cmdb/item/${item.id}/delete"
                             cssClass="delete"/>

                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty items}">
                <tr>
                    <td colspan="1000">
                        <spring:message code="no_result.label" />
                    </td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <p class="buttons">
        <ui:actionButton action="/cmdb/item/add/${itemClass.id}"
            disabled="${readOnly or itemClass.abstraction}"
            label="add.label"
            cssClass="add"/>
    </p>
</ui:panel>