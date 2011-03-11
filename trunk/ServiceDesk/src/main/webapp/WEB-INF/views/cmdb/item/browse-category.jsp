<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="caption.cmdb.item.class.related">
    <h1><spring:message code="caption.cmdb.item.class.parent"/></h1>
    <link:itemsByClass object="${itemClass.parent}" />

    <h1><spring:message code="caption.cmdb.item.class.children"/></h1>

    <print:nullable object="${itemClass.children}">
        <c:forEach items="${itemClass.children}" var="child">
            <link:itemsByClass object="${child}" />
        </c:forEach>
    </print:nullable>
</ui:panel>

<ui:panel caption="caption.cmdb.item.items">
    <table class="tablesorter">
        <thead>
            <tr>
                <th><spring:message code="field.cmdb.item.id" /></th>
                <c:forEach items="${itemClass.allAttributesSorted}" var="attribute">
                    <th>${attribute.name}</th>
                </c:forEach>
                <th class="actions"><spring:message code="caption.cmdb.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>
                        <link:item object="${item}"/>
                    </td>

                    <c:forEach items="${itemClass.allAttributesSorted}" var="attribute">
                        <td>
                            <cmdb:attributeValue attribute="${attribute}" entity="${item}" />
                        </td>
                    </c:forEach>

                    <td class="actions">
                        <ui:actionButton label="edit.label"
                             action="/cmdb/item/${item.id}/edit"
                             cssClass="edit"/>

                        <ui:actionButton label="delete.label"
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
</ui:panel>