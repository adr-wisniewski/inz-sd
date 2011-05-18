<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" href="<c:url value="/favicon.ico"/>" type="image/x-icon" />
<link rel="shortcut icon" href="<c:url value="/favicon.ico"/>" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="<c:url value="/static/styles/basic.css" />" media="screen" />

<script type="text/javascript" src="<c:url value="/static/scripts/jquery/jquery-1.6.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/hoverIntent.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/jquery.tablesorter.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/jquery.cookie.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/jquery.treeview.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/jquery-ui-1.8.12.custom.min.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/jquery/timepicker.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/scripts/collapsible_menu.js" /> "></script>
<script type="text/javascript">

// initialise plugins
jQuery(function(){
        $(".tablesorter").not(".custom").tablesorter({widgets: ['zebra']});
        $(".buttonGroup input:button, .buttonGroup input:submit, .buttonGroup a").button();
        $(".button").button();
        $("#navigation .menuGroup").collapsible_menu();
});

</script>