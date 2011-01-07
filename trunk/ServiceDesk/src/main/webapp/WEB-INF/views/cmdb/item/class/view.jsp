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
        <ui:actionButton label="edit.label" cssClass="edit">
            <jsp:attribute name="action">
                <spring:url value="/cmdb/item/class/{id}/edit">
                    <spring:param name="id">
                        ${itemClass.id}
                    </spring:param>
                </spring:url>
            </jsp:attribute>
        </ui:actionButton>

        <ui:actionButton label="delete.label" cssClass="delete">
           <jsp:attribute name="action">
                <spring:url value="/cmdb/item/class/{id}/delete">
                    <spring:param name="id">
                        ${itemClass.id}
                    </spring:param>
                </spring:url>
            </jsp:attribute>
        </ui:actionButton>
    </p>
</ui:panel>

<ui:panel caption="cmdb.item.class.attributes">
    <cmdb:attributeList list="${itemClass.attributes}" />
    <p class="buttons">
         <ui:actionButton label="add.label" cssClass="add">
                <jsp:attribute name="action">
                    <spring:url value="/cmdb/class/{id}/attribute/add">
                        <spring:param name="id">
                            ${itemClass.id}
                        </spring:param>
                    </spring:url>
                </jsp:attribute>
        </ui:actionButton>
    </p>
</ui:panel>

<ui:panel caption="cmdb.item.class.attributes.inherited">
    <cmdb:attributeList list="${itemClass.inheritedAttributes}" />
</ui:panel>