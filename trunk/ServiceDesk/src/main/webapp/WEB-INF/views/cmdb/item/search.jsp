<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:hint code="hint.cmdb.namesearch" />

<ui:element>
    <form:form modelAttribute="criteria" method="get">
        <form:errors path="*" cssClass="error" />
        <table class="tablesorter">
            <thead>
                <tr>
                    <th><spring:message code="field.cmdb.item.class" /></th>
                    <th><spring:message code="field.cmdb.item.label" /></th>
                    <th><spring:message code="field.cmdb.item.overview" /></th>
                    <th class="actions1"><spring:message code="caption.actions" /></th>
                </tr>
                <tr>
                    <td>
                       &nbsp;
                    </td>
                    <td>
                        <form:input path="label" />
                    </td>
                    <td>
                       &nbsp;
                    </td>
                    <td>
                        <input type="submit" value="<spring:message code="search.label" />" class="button" />
                    </td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>
                            ${item.itemClass.name}
                        </td>
                        <td>
                            ${item.label}
                        </td>
                        <td>
                            ${item.overview}
                        </td>
                        <td class="actions1">
                            <ui:actionButton label="details.label"
                                action="/cmdb/item/${item.id}"
                                cssClass="details"/>
                        </td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${not criteria.initialized}">
                        <tr>
                            <td colspan="20">
                                <spring:message code="caption.query_empty" />
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${empty items}">
                        <tr>
                            <td colspan="20">
                                <spring:message code="no_result.label" />
                            </td>
                        </tr>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </form:form>
</ui:element>