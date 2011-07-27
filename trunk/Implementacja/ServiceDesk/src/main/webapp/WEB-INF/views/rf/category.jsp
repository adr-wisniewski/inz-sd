<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>

<div class="main_label"><spring:message code="choose_category.label" />:</div>

<sd:treeView roots="${categories}" urlFormat="/rf/add?id=%s"/>