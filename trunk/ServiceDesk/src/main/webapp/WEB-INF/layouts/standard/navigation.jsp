<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="menu" tagdir="/WEB-INF/tags/ui/menu" %>

<c:set var="username" scope="page">
    <security:authentication property="name"></security:authentication>
</c:set>

<menu:menuGroup name="general.label" id="menu-general">
    <menu:menuItem url="/" name="home.label" />
    <menu:menuItem url="/j_spring_security_logout" name="logout.label" name_args="${username}" />
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

<menu:menuGroup name="menu.cmdb.caption" id="menu-cn">
    <menu:compositeMenuItem url="/cmdb/item" name="menu.cmdb.item">
        <menu:menuItem url="/cmdb/item/add" name="menu.cmdb.item.add" role="CN_ITM_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/item/browse" name="menu.cmdb.item.browse" role="CN_ITM_VIE" icon="search"/>
    </menu:compositeMenuItem>

    <menu:compositeMenuItem url="/cmdb/item/class" name="menu.cmdb.item.class">
        <menu:menuItem url="/cmdb/item/class/add" name="menu.cmdb.item.class.add" role="CN_ITC_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/item/class/browse" name="menu.cmdb.item.class.browse" role="CN_ITC_VIE" icon="search"/>
        <menu:menuItem url="/cmdb/item/class/search" name="menu.cmdb.item.class.search" role="CN_ITC_VIE" icon="search"/>
    </menu:compositeMenuItem>

    <menu:compositeMenuItem url="/cmdb/relationship/class" name="menu.cmdb.relationship.class">
        <menu:menuItem url="/cmdb/relationship/class/add" name="menu.cmdb.relationship.class.add" role="CN_RLC_ADD" icon="add"/>
        <menu:menuItem url="/cmdb/relationship/class/browse" name="menu.cmdb.relationship.class.browse" role="CN_RLC_VIE" icon="search"/>
        <menu:menuItem url="/cmdb/relationship/class/search" name="menu.cmdb.relationship.class.search" role="CN_RLC_VIE" icon="search"/>
    </menu:compositeMenuItem>
</menu:menuGroup>


<menu:menuGroup name="administration.label" id="menu-admin">
    <menu:menuItem url="/sd/searchEmployee" name="search_employees.label"/>
    <menu:compositeMenuItem name="signals.label" url="#">
        <menu:menuItem url="/signal/addtype" name="add_type.label"/>
        <menu:menuItem url="/signal/typelist" name="signal_types.label"/>
        <menu:menuItem url="/signal/addgenerator" name="add_generator.label"/>
        <menu:menuItem url="/signal/generatorlist" name="signal_generators.label"/>
    </menu:compositeMenuItem>
</menu:menuGroup>