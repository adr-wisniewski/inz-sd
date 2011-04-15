<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ attribute name="signals" required="true" rtexprvalue="true" type="java.util.Collection"  %>

<div>
    <table class="box" id="sygnaly">
        <thead>
            <tr>
                <th colspan="20"><spring:message code="signals.label" /></th>
            </tr>
        </thead>
        <tbody class=data-table-body>
            <tr class=data-table-header>
                <td><spring:message code="creationDate.label" /></td>
                <td><spring:message code="signal_subject.label" /></td>
                <td><spring:message code="signal_message.label" /></td>
                <td><spring:message code="signal_significance.label" /></td>
                <td></td>
            </tr>
            <c:forEach items="${signals}" var="s">
            <tr class="${s.type.significance.cssClass}">
                <td>${s.creationDate}</td>
                <td>${s.subject}</td>
                <td>${s.message}</td>
                <td>${s.type.significance.name}</td>
                <td>
                    <sd:editButton url="${s.detailsURL}"/>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>