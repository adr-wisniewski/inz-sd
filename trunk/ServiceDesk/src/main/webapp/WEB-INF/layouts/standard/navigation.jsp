<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="menu" tagdir="/WEB-INF/tags/ui/menu" %>

<c:set var="username" scope="page">
    <security:authentication property="name"></security:authentication>
</c:set>

<div id="greeting">
    <spring:message code="common.greeting"/>
    <em>${username}</em><br/>
    
    <a href="/"><spring:message code="home.label" /></a> |
    <a href="/j_spring_security_logout"><spring:message code="logout.label" /></a>
</div>

<menu:menuGroup name="menu.cmdb.caption" id="menu-cmdb">
    <menu:compositeMenuItem url="/cmdb/item" name="menu.cmdb.item">
        <menu:menuItem url="/cmdb/item/add" name="menu.cmdb.item.add" role="CMDB_ITEM_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/item/browse" name="menu.cmdb.item.browse" role="CMDB_ITEM_VIEW" icon="search"/>
        <menu:menuItem url="/cmdb/item/search" name="menu.cmdb.item.search" role="CMDB_ITEM_VIEW" icon="search"/>
    </menu:compositeMenuItem>

    <menu:compositeMenuItem url="/cmdb/item/class" name="menu.cmdb.item.class">
        <menu:menuItem url="/cmdb/item/class/add" name="menu.cmdb.item.class.add" role="CMDB_ITEMCLASS_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/item/class/browse" name="menu.cmdb.item.class.browse" role="CMDB_ITEMCLASS_VIEW" icon="search"/>
        <menu:menuItem url="/cmdb/item/class/search" name="menu.cmdb.item.class.search" role="CMDB_ITEMCLASS_VIEW" icon="search"/>
    </menu:compositeMenuItem>

    <menu:compositeMenuItem url="/cmdb/relationship/class" name="menu.cmdb.relationship.class">
        <menu:menuItem url="/cmdb/relationship/class/add" name="menu.cmdb.relationship.class.add" role="CMDB_RELATIONSHIPCLASS_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/relationship/class/browse" name="menu.cmdb.relationship.class.browse" role="CMDB_RELATIONSHIPCLASS_VIEW" icon="search"/>
        <menu:menuItem url="/cmdb/relationship/class/search" name="menu.cmdb.relationship.class.search" role="CMDB_RELATIONSHIPCLASS_VIEW" icon="search"/>
    </menu:compositeMenuItem>
</menu:menuGroup>

<menu:menuGroup name="menu.change" id="menu-change">
    
    <menu:menuItem url="/change/rfc/add" name="menu.change.rfc.add" role="CHANGE_RFC_ADD" icon="add"/>
    
    <menu:compositeMenuItem url="/change/rfc/browse" name="menu.change.rfc.browse">
        <menu:menuItem url="/change/rfc/created" name="menu.change.rfc.created" role="CHANGE_RFC_ADD" icon="search"/>
        <menu:menuItem url="/change/rfc" name="menu.change.rfc" role="CHANGE_RFC_VIEW" icon="search"/>
    </menu:compositeMenuItem>
    
    <menu:compositeMenuItem url="/change/rfc/manage" name="menu.change.rfc.manage">
        <menu:menuItem url="/change/rfc/unassigned" name="menu.change.rfc.unassigned" role="CHANGE_RFC_MANAGE" icon="search"/>
        <menu:menuItem url="/change/rfc/managed" name="menu.change.rfc.managed" role="CHANGE_RFC_MANAGE" icon="search"/>
    </menu:compositeMenuItem>
    
    <menu:compositeMenuItem url="/change/rfc/administer" name="menu.change.rfc.administer">
        <menu:menuItem url="/change/rfc/priority" name="menu.change.rfc.priority" role="CHANGE_RFC_PRIORITY_CRUD" icon="search"/>
        <menu:menuItem url="/change/rfc/impact" name="menu.change.rfc.impact" role="CHANGE_RFC_IMPACT_CRUD" icon="search"/>
        <menu:menuItem url="/change/rfc/category" name="menu.change.rfc.category" role="CHANGE_RFC_CATEGORY_CRUD" icon="search"/>
        <menu:menuItem url="/change/rfc/resolution" name="menu.change.rfc.resolution" role="CHANGE_RFC_RESOLUTION_CRUD" icon="search"/>
    </menu:compositeMenuItem>
    
</menu:menuGroup>

<menu:menuGroup name="em.label" id="menu-em">
    <menu:menuItem url="/em/search" name="search_events.label" role="SEARCH_EM"/>
    <menu:compositeMenuItem name="reports.label" url="#">
         <menu:menuItem url="/report?name=emCategoryReport&amp;format=pdf" name="emCategory.report"/>
         <menu:menuItem url="/report?name=emSignificanceReport&amp;format=pdf" name="emSignificance.report"/>
         <menu:menuItem url="/report?name=emIncidentReport&amp;format=pdf" name="emIncident.report"/>
    </menu:compositeMenuItem>
</menu:menuGroup>

<menu:menuGroup name="im.label" id="menu-im">
    <menu:menuItem url="/im/add" name="add_incident.label" role="ADD_IM"/>
    <menu:menuItem url="/im/myOpen" name="my_open_incidents.label" role="MY_OPEN_IM"/>
    <menu:menuItem url="/im/myClosed" name="my_closed_incidents.label" role="MY_CLOS_IM"/>
    <menu:menuItem url="/im/search" name="search_incident.label" role="SEARCH_IM"/>
    <menu:menuItem url="/im/notAssigned" name="notAssigned.label" role="SEARCH_IM"/>
    <menu:menuItem url="/im/myAssigned" name="myAssigned.label" role="ASSIGN_IM"/>
    <menu:compositeMenuItem name="reports.label" url="#">
        <menu:menuItem url="/report?name=imCategoryReport&amp;format=pdf" name="imCategory.report"/>
        <menu:menuItem url="/report?name=imSourceReport&amp;format=pdf" name="imSource.report"/>
        <menu:menuItem url="/report?name=imPriorityReport&amp;format=pdf" name="imPriority.report"/>
        <menu:menuItem url="/report?name=imSupportGroupReport&amp;format=pdf" name="imSupportGroup.report"/>
        <menu:menuItem url="/report?name=imResolvedReport&amp;format=pdf" name="imResolved.report"/>
    </menu:compositeMenuItem>
</menu:menuGroup>

<menu:menuGroup name="pm.label" id="menu-pm">
    <menu:menuItem url="/pm/add" name="add_problem.label" role="ADD_PM"/>
    <menu:menuItem url="/pm/search" name="search_problems.label" role="SEARCH_PM"/>
    <menu:menuItem url="/pm/kedb" name="search_errors.label" role="SEARCH_KE"/>
    <menu:compositeMenuItem name="reports.label" url="#">
        <menu:menuItem url="/report?name=pmCategoryReport&amp;format=pdf" name="pmCategory.report"/>
    </menu:compositeMenuItem>
</menu:menuGroup>

<menu:menuGroup name="rf.label" id="menu-rm">
    <menu:menuItem url="/rf/category" name="add_request.label" role="ADD_RF"/>
    <menu:menuItem url="/rf/search" name="search_request.label" role="SEARCH_RF"/>
</menu:menuGroup>

<menu:menuGroup name="administration.label" id="menu-admin">
    <menu:menuItem url="/common/announcement" name="menu.common.announcements" role="COMMON_ANNOUNCEMENT_CRUD"/>
    <menu:menuItem url="/servicedesk/searchEmployee" name="search_employees.label" role="ADMIN"/>
    <menu:compositeMenuItem name="signals.label" url="#">
        <menu:menuItem url="/signal/addtype" name="add_type.label" role="ADMIN"/>
        <menu:menuItem url="/signal/typelist" name="signal_types.label" role="ADMIN"/>
        <menu:menuItem url="/signal/addgenerator" name="add_generator.label" role="ADMIN"/>
        <menu:menuItem url="/signal/generatorlist" name="signal_generators.label" role="ADMIN"/>
    </menu:compositeMenuItem>
</menu:menuGroup>