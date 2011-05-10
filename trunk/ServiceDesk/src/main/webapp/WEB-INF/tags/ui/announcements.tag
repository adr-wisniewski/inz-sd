<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ attribute name="announcements" required="true" rtexprvalue="true" type="java.util.Collection" %>
<%@ attribute name="buttons" required="false" fragment="true" %>
<%@ attribute name="bottom" required="false" fragment="true" %>

<%@ variable name-given="announcement" variable-class="servicedesk.common.announcement.domain.Announcement" %>

<ui:panel caption="news.label" cssClass="announcements">
    <c:forEach items="${announcements}" var="announcement">
        <div class="item">
            <div class="title">
                ${announcement.title}
            </div>
            <div class="body">
                ${announcement.content}
            </div>
            <div class="signature">
                <print:datetime datetime="${announcement.publicationTime}" /> 
                -
                <link:employee object="${announcement.creator}" />
            </div>
            <c:if test="${not empty pageScope.buttons}">
                <div>
                    <jsp:invoke fragment="buttons" />
                </div>
            </c:if>
        </div>

        <hr class="horizontal-line">
    </c:forEach>

    <c:if test="${empty announcements}">
        <div class="item">
            <div class="body">
                <spring:message code="caption.common.announcements.empty" />
            </div>
        </div>
    </c:if>

    <c:if test="${not empty pageScope.bottom}">
        <div>
            <jsp:invoke fragment="bottom" />
        </div>
    </c:if>
</ui:panel>