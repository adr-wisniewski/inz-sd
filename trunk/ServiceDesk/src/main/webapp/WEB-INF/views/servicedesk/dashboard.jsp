<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element cssClass="dashboard">
    <ui:announcements announcements="${announcements}" />
</ui:element>

