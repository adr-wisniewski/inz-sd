<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:hint code="cmdb.item.class.hint.namesearch" />

<ui:element>
    <form:form modelAttribute="itemClassCriteria" method="get">
        <form:errors path="*" cssClass="error" />
        <table class="tablesorter">
            <thead>
                <tr>
                    <th><spring:message code="cmdb.item.class.field.id" /></th>
                    <th><spring:message code="cmdb.item.class.field.name" /></th>
                    <th><spring:message code="cmdb.item.class.field.description" /></th>
                    <th><spring:message code="cmdb.item.class.field.parent" /></th>
                    <th><spring:message code="cmdb.item.class.field.abstraction" /></th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <form:input path="id" />
                    </td>
                    <td>
                        <form:input path="name" />
                    </td>
                    <td>
                        <form:input path="description" />
                    </td>
                    <td>
                        <form:input path="parentName" />
                    </td>
                    <td>
                        <form:select path="abstraction">
                            <form:option value="${null}" label="" />
                            <form:option value="${true}" label="Yes" />
                            <form:option value="${false}" label="No" />
                        </form:select>
                    </td>
                    <td>
                        <input type="submit" value="<spring:message code="search.label" />" class="button" />
                    </td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${itemClasses}" var="itemClass">
                    <tr>
                        <td>
                            ${itemClass.id}
                        </td>
                        <td>
                            ${itemClass.name}
                        </td>
                        <td>
                            ${itemClass.description}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${itemClass.parent != null}">
                                    ${itemClass.parent.name}
                                </c:when>
                                <c:otherwise>
                                    <spring:message code="cmdb.item.class.field.parent.empty" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            ${itemClass.abstraction}
                        </td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${not itemClassCriteria.initialized}">
                        <tr>
                            <td colspan="20">
                                <spring:message code="cmdb.query_empty" />
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${empty itemClasses}">
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


