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
            <c:out value="${item.id}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.item.label">
            <c:out value="${item.label}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.item.overview">
            <c:out value="${item.overview}" />
        </ui:propertyItem>

        <c:forEach items="${item.itemClass.allAttributesSorted}" var="attribute">
            <ui:propertyItem caption="${attribute.name}">
                <cmdb:attributeValue attribute="${attribute}" entity="${item}" />
            </ui:propertyItem>
        </c:forEach>
    </ui:propertyList>

    <p class="buttons">

        <c:choose>
            <c:when test="${detailView != null}">
                <ui:actionButton label="caption.cmdb.item.goto.specificModule"
                    action="${detailView}"
                    cssClass="goto"/>
            </c:when>
            <c:otherwise>
                <ui:actionButton label="edit.label"
                    action="/cmdb/item/${item.id}/edit"
                    cssClass="edit"/>

                <ui:actionButton label="delete.label"
                    action="/cmdb/item/${item.id}/delete"
                    cssClass="delete"/>
            </c:otherwise>
        </c:choose>

  
        
    </p>
</ui:panel>

<ui:panel caption="caption.cmdb.item.relationships">
    <cmdb:relatedItems item="${item}" relationships="${relationships}" />
</ui:panel>
