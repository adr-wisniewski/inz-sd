<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:hint code="hint.cmdb.namesearch" />

<ui:element>
    <form:form modelAttribute="rfcCriteria" method="get">
        <form:errors path="*" cssClass="error" />
        <table class="tablesorter">
            <thead>
                <tr>
                    <th><spring:message code="field.change.rfc.id" /></th>
                    <th><spring:message code="field.change.rfc.title" /></th>
                    <th><spring:message code="field.change.rfc.description" /></th>
                    <th><spring:message code="field.change.rfc.priority" /></th>
                    <th><spring:message code="field.change.rfc.impact" /></th>
                    <th><spring:message code="field.change.rfc.state" /></th>
                    <th class="actions1"><spring:message code="caption.actions" /></th>
                </tr>
                <tr>
                    <td>
                        <form:input path="id" />
                        <form:errors path="id" cssClass="error" />
                    </td>
                    <td>
                        <form:input path="title" />
                        <form:errors path="title" cssClass="error" />
                    </td>
                    <td>
                        <form:input path="description" />
                        <form:errors path="description" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="priority">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${priorities}" />
                        </form:select>
                        <form:errors path="priority" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="impact">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${impacts}" />
                        </form:select>
                        <form:errors path="impact" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="state">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${states}" />
                        </form:select>
                        <form:errors path="state" cssClass="error" />
                    </td>
                    <td>
                        <input type="submit" value="<spring:message code="search.label" />" class="button" />
                    </td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${rfcs}" var="rfc">
                    <tr>
                        <td>
                            ${rfc.id}
                        </td>
                        <td>
                            ${rfc.title}
                        </td>
                        <td>
                            ${rfc.description}
                        </td>
                        <td>
                            ${rfc.priority.name}
                        </td>
                        <td>
                            ${rfc.impact.name}
                        </td>
                        <td>
                            ${rfc.state.name}
                        </td>
                        <td class="actions1">
                            <ui:actionButton label="details.label"
                                action="/change/rfc/${itemClass.id}"
                                cssClass="details"/>
                        </td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${not rfcCriteria.initialized}">
                        <tr>
                            <td colspan="20">
                                <spring:message code="caption.query_empty" />
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${empty rfcs}">
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