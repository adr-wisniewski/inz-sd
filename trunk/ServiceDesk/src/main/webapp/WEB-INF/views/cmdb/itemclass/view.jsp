<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:panel caption="fieldgroup.cmdb.entity.class.simple">
    <ui:propertyList>
        <ui:propertyItem code="field.cmdb.entity.class.name">
            ${universalItemClass.name}
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.description">
            ${universalItemClass.description}
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.abstraction">
            <print:yesorno value="${universalItemClass.abstraction}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.parent">
            <link:itemClass object="${universalItemClass.parent}" />
        </ui:propertyItem>
    </ui:propertyList>

    <p class="buttons">
        <ui:actionButton label="edit.label" 
                         action="/cmdb/item/class/${universalItemClass.id}/edit"
                         cssClass="edit"/>
            
        <ui:actionButton label="delete.label" 
                         action="/cmdb/item/class/${universalItemClass.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>

<ui:panel caption="fieldgroup.cmdb.entity.class.attributes">
    <cmdb:attributeList list="${universalItemClass.attributes}"
        editUrl="/cmdb/class/${universalItemClass.id}/attribute/{id}/edit"
        deleteUrl="/cmdb/class/${universalItemClass.id}/attribute/{id}/delete" />
    
    <p class="buttons">
        <ui:actionButton label="add.label" 
                         action="/cmdb/class/${universalItemClass.id}/attribute/add"
                         cssClass="add" />
    </p>
</ui:panel>

<ui:panel caption="fieldgroup.cmdb.entity.class.attributes.all">
    <cmdb:attributeList list="${universalItemClass.allAttributes}" />
</ui:panel>