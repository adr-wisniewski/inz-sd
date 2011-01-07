<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:panel caption="cmdb.item.class.group.simple">
    <ui:propertyList>
        <ui:propertyItem code="cmdb.item.class.field.name">
            ${itemClass.name}
        </ui:propertyItem>

        <ui:propertyItem code="cmdb.item.class.field.description">
            ${itemClass.description}
        </ui:propertyItem>

        <ui:propertyItem code="cmdb.item.class.field.abstraction">
            <print:yesorno value="${itemClass.abstraction}" />
        </ui:propertyItem>

        <ui:propertyItem code="cmdb.item.class.field.parent">
            <link:itemClass object="${itemClass.parent}" />
        </ui:propertyItem>
    </ui:propertyList>

    <p class="buttons">
        <ui:actionButton label="edit.label" 
                         action="/cmdb/item/class/${itemClass.id}/edit"
                         cssClass="edit"/>
            
        <ui:actionButton label="delete.label" 
                         action="/cmdb/item/class/${itemClass.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>

<ui:panel caption="cmdb.item.class.attributes">
    <cmdb:attributeList list="${itemClass.attributes}" 
        editUrl="/cmdb/class/${itemClass.id}/attribute/{id}/edit"
        deleteUrl="/cmdb/class/${itemClass.id}/attribute/{id}/delete" />
    
    <p class="buttons">
        <ui:actionButton label="add.label" 
                         action="/cmdb/class/${itemClass.id}/attribute/add"
                         cssClass="add" />
    </p>
</ui:panel>

<ui:panel caption="cmdb.item.class.attributes.inherited">
    <cmdb:attributeList list="${itemClass.inheritedAttributes}" />
</ui:panel>