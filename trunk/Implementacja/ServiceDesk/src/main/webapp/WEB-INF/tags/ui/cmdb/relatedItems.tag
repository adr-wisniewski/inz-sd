<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="relationships" required="true" rtexprvalue="true" type="java.util.List<servicedesk.core.itil.cmdb.domain.Relationship>"%>
<%@attribute name="item" required="true" rtexprvalue="true" type="servicedesk.core.itil.cmdb.domain.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

 <table class="tablesorter">
    <thead>
        <tr>
            <th><spring:message code="caption.cmdb.relationship.related.label" /></th>
            <th><spring:message code="caption.cmdb.relationship.related.overview" /></th>
            <th><spring:message code="caption.cmdb.relationship.related.item" /></th>
            <th><spring:message code="caption.cmdb.relationship.related.item.overview" /></th>
            <th class="fit noSort"><spring:message code="caption.actions" /></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="relationship" items="${relationships}">
            <c:choose>
                <c:when test="${item.id eq relationship.sourceItem.id}">
                    <c:set var="label" value="${relationship.relationshipClass.label}" />
                    <c:set var="second" value="${relationship.targetItem}" />
                </c:when>
                <c:otherwise>
                    <c:set var="label" value="${relationship.relationshipClass.reverseLabelSafe}" />
                    <c:set var="second" value="${relationship.sourceItem}" />
                </c:otherwise>
            </c:choose>
            <tr>
                <td>
                    ${label}
                </td>
                <td>
                    ${relationship.overview}
                </td>
                <td>
                    ${second.label}
                </td>
                <td>
                    ${second.overview}
                </td>
                <td class="actions">
                    <ui:actionButton label="details.label"
                        action="/cmdb/relationship/${relationship.id}"
                        cssClass="details"/>
                    
                    <ui:actionButton label="edit.label"
                        action="/cmdb/relationship/${relationship.id}/edit"
                        cssClass="edit"/>

                    <ui:actionButton label="delete.label"
                        action="/cmdb/relationship/${relationship.id}/delete"
                        cssClass="delete"
                        role="CHANGE_RFC_EDIT" />
                </td>
            </tr>
        </c:forEach>   
        <c:if test="${empty relationships}">
            <tr>
                <td colspan="20">
                    <spring:message code="caption.change.rfc.related.empty" />
                </td>
            </tr>
        </c:if>
    </tbody>
</table>
<p class="buttons">
    <ui:actionButton label="add.label"
                     action="/cmdb/relationship/addForItem/${item.id}"
                     cssClass="add"
                     role="CHANGE_RFC_EDIT" />
</p>            
