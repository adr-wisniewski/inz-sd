<%@ tag body-content="empty" description="" %>
<%@ attribute name="items" required="true" description="" type="java.util.List"%>
<%@ attribute name="label" required="true" description="label" fragment="true" %>
<%@ attribute name="headerCode" required="false" description="label" %>
<%@ attribute name="actions" required="false" description="label" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="util" uri="/WEB-INF/util.tld" %>
<%@ variable name-given="item" variable-class="java.lang.Object" %>

<c:if test="${empty items}">
    <c:set var="cssClass" value="empty" />
</c:if>

<c:set var="cssClass2" value="listview" />
<c:if test="${not empty pageScope.actions}">
    <c:set var="cssClass2" value="tablesorter" />
</c:if>

<table class="${cssClass} ${cssClass2}">
    <c:if test="${not empty pageScope.actions}">
    <thead>
        <tr>
            <th>
                <spring:message code="${headerCode}" />
            </th>
            <th class="fit noSort">
                <spring:message code="actions" />
            </th>
        </tr>   
    </thead>
    </c:if>
    <tbody>
        <c:forEach items="${items}" var="item">
        <tr>    
            <td>
                <jsp:invoke fragment="label" />
            </td> 
            <c:if test="${not empty pageScope.actions}">
                <td>
                    <jsp:invoke fragment="actions" />
                </td>
            </c:if>
        </tr>
        </c:forEach>
        <c:if test="${empty items}">
            <tr>
                <td colspan="2">
                    <spring:message code="null" />
                </td>
            </tr>
        </c:if>
    </tbody>
</table>