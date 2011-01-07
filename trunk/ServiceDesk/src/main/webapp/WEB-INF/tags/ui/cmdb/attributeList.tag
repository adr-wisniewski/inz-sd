<%-- 
    Document   : attributeList
    Created on : 2010-12-10, 11:58:51
    Author     : Adrian
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="list" required="true" rtexprvalue="true" type="java.util.List" %>


<table class="tablesorter">
    <thead>
        <tr>
            <th><spring:message code="cmdb.attribute.field.name" /></th>
            <th><spring:message code="cmdb.attribute.field.description" /></th>
            <th><spring:message code="cmdb.attribute.field.class" /></th>
            <th></th>
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
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty list}">
            <tr>
                <td colspan="20">
                    <spring:message code="cmdb.attribute.emptylist" />
                </td>
            </tr>
        </c:if>
    </tbody>
</table>