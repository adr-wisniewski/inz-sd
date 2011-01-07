<%-- 
    Document   : attributeList
    Created on : 2010-12-10, 11:58:51
    Author     : Adrian
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<%@attribute name="list" required="true" rtexprvalue="true" type="java.util.List" %>
<%@attribute name="editUrl" required="false" rtexprvalue="true" %>
<%@attribute name="deleteUrl" required="false" rtexprvalue="true" %>

<table class="tablesorter">
    <thead>
        <tr>
            <th><spring:message code="cmdb.class.attribute.field.name" /></th>
            <th><spring:message code="cmdb.class.attribute.field.description" /></th>
            <th><spring:message code="cmdb.class.attribute.field.class" /></th>
            <th>
                <c:if test="${not empty editUrl or not empty deleteUrl}">
                     <spring:message code="actions" />
                </c:if>
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="attribute">
            <tr>
                <td>
                    ${attribute.name}
                </td>
                <td>
                    ${attribute.description}
                </td>
                <td>
                    ${attribute.elementClass.name}
                </td>
                <td>
                    <c:if test="${not empty editUrl}">
                        <ui:actionButton label="edit.label" cssClass="edit">
                            <jsp:attribute name="action">
                                <spring:url value="${editUrl}">
                                    <spring:param name="id">${attribute.id}</spring:param>
                                </spring:url>
                            </jsp:attribute>
                        </ui:actionButton>
                    </c:if>
                    <c:if test="${not empty deleteUrl}">
                        <ui:actionButton label="delete.label" cssClass="delete">
                            <jsp:attribute name="action">
                                <spring:url value="${deleteUrl}">
                                    <spring:param name="id">${attribute.id}</spring:param>
                                </spring:url>
                            </jsp:attribute>
                        </ui:actionButton>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty list}">
            <tr>
                <td colspan="20">
                    <spring:message code="cmdb.class.attribute.emptylist" />
                </td>
            </tr>
        </c:if>
    </tbody>
</table>