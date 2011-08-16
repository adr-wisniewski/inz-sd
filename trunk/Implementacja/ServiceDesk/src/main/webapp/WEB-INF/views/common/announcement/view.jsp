<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:panel caption="fieldgroup.common.announcement.simple">
    <ui:propertyList>
        <ui:propertyItem code="field.common.announcement.title">
            ${announcement.title}
        </ui:propertyItem>

        <ui:propertyItem code="field.common.announcement.content">
            ${announcement.content}
        </ui:propertyItem>

        <ui:propertyItem code="field.common.announcement.author">
            <link:user object="${announcement.author}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.common.announcement.publicationTime">
            <print:datetime datetime="${announcement.publicationTime}" />
        </ui:propertyItem>
    </ui:propertyList>

    <p class="buttons">
        <ui:actionButton label="edit.label" 
            action="/common/announcement/${announcement.id}/edit"
            cssClass="edit"/>
            
        <ui:actionButton label="delete.label" 
            action="/common/announcement/${announcement.id}/delete"
            cssClass="delete"/>
    </p>
</ui:panel>