<%@ tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ attribute name="announcements" required="true" rtexprvalue="true" type="java.util.Collection"  %>

<div class="dashboardpanel announcements">
    <div class="header">
        <spring:message code="news.label" />
    </div>

    <c:forEach items="${announcements}" var="announcement">
        <div class="item">
            <div class="title">
                ${announcement.title}
            </div>
            <div class="time">
                ${announcement.publicationTime}
            </div>
            <div class="content">
                ${announcement.content}
            </div>
            <div class="author">
                <link:employee object="${announcement.author}" />
            </div>
        </div>

        <hr class="horizontal-line">
    </c:forEach>

    <c:if test="${empty announcements}">
        <div class="item">
            <div class="content">
                <spring:message code="common.caption.announcements.empty" />
            </div>
        </div>
    </c:if>
</div>