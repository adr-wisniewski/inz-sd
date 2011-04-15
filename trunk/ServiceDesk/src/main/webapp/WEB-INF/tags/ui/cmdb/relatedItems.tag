<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="relationshipClass" required="true" rtexprvalue="true" type="servicedesk.cmdb.domain.RelationshipClass"%>
<%@attribute name="reverse" required="true" rtexprvalue="true" type="java.lang.Boolean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="caption.cmdb.item.relationships" captionArgs="${relationshipClass.name}">
    <table class="tablesorter">
        <thead>
            <tr>
                <th><spring:message code="field.cmdb.item.class" /></th>
                <th><spring:message code="field.cmdb.item.label" /></th>
                <th><spring:message code="field.cmdb.item.overview" /></th>

                <c:forEach items="${relationshipClass.allAttributesSorted}" var="attribute">
                    <th><c:out value="${attribute.name}"/></th>
                </c:forEach>

                <th class="actions2"><spring:message code="caption.cmdb.actions" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${relationshipClass.instances}" var="relationship">
                <c:set var="relatedItem" value="${reverse ? relationship.sourceItem : relationship.targetItem}" />
                <tr>
                    <td>
                        <c:out value="${relatedItem.itemClass.name}" />
                    </td>

                    <td>
                        <c:out value="${relatedItem.label}" />
                    </td>

                    <td>
                        <c:out value="${relatedItem.overview}" />
                    </td>

                    <c:forEach items="${relationshipClass.allAttributesSorted}" var="attribute">
                        <td><cmdb:attributeValue attribute="${attribute}" entity="${relationship}" /></td>
                    </c:forEach>

                    <td class="actions2">
                        <ui:actionButton label="edit.label"
                             action="/cmdb/relationship/${relationship.id}/edit"
                             cssClass="edit"/>

                        <ui:actionButton label="delete.label"
                             action="/cmdb/relationship/${relationship.id}/delete"
                             cssClass="delete"/>

                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty relationshipClass.instances}">
                <tr>
                    <td colspan="1000">
                        <spring:message code="no_result.label" />
                    </td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <p class="buttons">
        <c:choose>
            <c:when test="${reverse}">
                <ui:actionButton action="/cmdb/relationship/add/${relationshipClass.id}/target/${item.id}"
                    label="add.label"
                    cssClass="add"/>
            </c:when>
            <c:otherwise>
                <ui:actionButton action="/cmdb/relationship/add/${relationshipClass.id}/source/${item.id}"
                    label="add.label"
                    cssClass="add"/>
            </c:otherwise>
        </c:choose>
    </p>
</ui:panel>
