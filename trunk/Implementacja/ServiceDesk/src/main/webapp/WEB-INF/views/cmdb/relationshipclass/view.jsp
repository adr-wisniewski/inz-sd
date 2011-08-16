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
            ${relationshipClass.name}
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.abstraction">
            <print:yesorno value="${relationshipClass.abstraction}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.parent">
            <link:relationshipClass object="${relationshipClass.parent}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.relationship.class.sourceItemClass">
            <c:choose>
                <c:when test="${relationshipClass.sourceItemClass == null}">
                    <spring:message code="caption.cmdb.relationship.class.any" />
                </c:when>
                <c:otherwise>
                    <link:itemClass object="${relationshipClass.sourceItemClass}" />
                </c:otherwise>
            </c:choose>
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.relationship.class.targetItemClass">
            <c:choose>
                <c:when test="${relationshipClass.targetItemClass == null}">
                    <spring:message code="caption.cmdb.relationship.class.any" />
                </c:when>
                <c:otherwise>
                    <link:itemClass object="${relationshipClass.targetItemClass}" />
                </c:otherwise>
            </c:choose>
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.relationship.class.label">
            ${relationshipClass.label}
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.relationship.class.reverseLabel">
            ${relationshipClass.reverseLabel}
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.entity.class.description">
            ${relationshipClass.description}
        </ui:propertyItem>

    </ui:propertyList>

    <p class="buttons">
        <ui:actionButton label="edit.label" 
                         action="/cmdb/relationship/class/${relationshipClass.id}/edit"
                         cssClass="edit"/>
            
        <ui:actionButton label="delete.label" 
                         action="/cmdb/relationship/class/${relationshipClass.id}/delete"
                         cssClass="delete"/>
    </p>
</ui:panel>

<ui:panel caption="fieldgroup.cmdb.entity.class.attributes">
    <cmdb:attributeList list="${relationshipClass.attributes}"
        editUrl="/cmdb/class/${relationshipClass.id}/attribute/{id}/edit"
        deleteUrl="/cmdb/class/${relationshipClass.id}/attribute/{id}/delete" />
    
    <p class="buttons">
        <ui:actionButton label="add.label" 
                         action="/cmdb/class/${relationshipClass.id}/attribute/add"
                         cssClass="add" />
    </p>
</ui:panel>

<ui:panel caption="fieldgroup.cmdb.entity.class.attributes.all">
    <cmdb:attributeList list="${relationshipClass.allAttributes}" />
</ui:panel>