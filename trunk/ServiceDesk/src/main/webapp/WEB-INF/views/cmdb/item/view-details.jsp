<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="caption.cmdb.item.attributes">
    <ui:propertyList>
        <ui:propertyItem code="field.cmdb.item.id">
            ${item.id}
        </ui:propertyItem>

        <c:forEach items="${item.itemClass.allAttributesSorted}" var="attribute">
            <ui:propertyItem caption="${attribute.name}">
                <cmdb:attributeValue attribute="${attribute}" entity="${item}" />
            </ui:propertyItem>
        </c:forEach>
    </ui:propertyList>

    <p class="buttons">
        <ui:actionButton label="edit.label"
            action="/cmdb/item/${item.id}/edit"
            cssClass="edit"/>

        <ui:actionButton label="delete.label"
            action="/cmdb/item/${item.id}/delete"
            cssClass="delete"/>
    </p>
</ui:panel>

<ui:panel caption="caption.cmdb.item.relationships">
    
</ui:panel>
