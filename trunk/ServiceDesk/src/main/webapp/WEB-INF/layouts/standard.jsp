<%@ page language="java" buffer="1024kb" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="/WEB-INF/util.tld" prefix="util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>

        <c:set var="title">
            <spring:message>
                <jsp:attribute name="code">
                    <tiles:getAsString name="title" />
                </jsp:attribute>
                <jsp:attribute name="arguments">
                    <tiles:getAsString name="title_args" />
                </jsp:attribute>
            </spring:message>
        </c:set>

        <title>
            <c:if test="${not empty title}"> ${util:stripTags(title)} :: </c:if> Service Desk
        </title>

        <tiles:insertTemplate template="/WEB-INF/layouts/head.jsp" flush="false" />
    </head>
    <body class="<tiles:getAsString name="bodyCssClass" />">
        <script type="text/javascript">
            var __START_TIME = new Date();
        </script>

        <div id="logo">
            <tiles:insertAttribute name="logo" flush="false" />
        </div>

        <div id="navigation">
            <tiles:insertAttribute name="navigation" flush="false" />
        </div>

        <div id="page">
            <div id="pagetitle">
                <h1>${title}</h1>
            </div>

            <tiles:insertAttribute name="messagebox" flush="false" />

            <tiles:insertAttribute name="body" flush="false" />
        </div>

        <div id="footer">
            <tiles:insertAttribute name="footer" flush="false" />
        </div>
    </body>
</html>