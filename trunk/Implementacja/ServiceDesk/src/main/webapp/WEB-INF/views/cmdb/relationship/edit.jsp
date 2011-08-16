<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="caption.cmdb.relationship.properties">
    <form:form modelAttribute="relationship" method="post">
        <form:errors path="*" cssClass="errors" />
        <ui:propertyList>

            <ui:propertyItem code="field.cmdb.relationship.sourceItem" label="sourceItem">
                <cmdb:itemPicker name="sourceItem" value="${relationship.sourceItem}" clazz="${relationship.relationshipClass.sourceItemClass}" />
                <form:errors path="sourceItem" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.cmdb.relationship.targetItem" label="targetItem">
                <cmdb:itemPicker name="targetItem" value="${relationship.targetItem}" clazz="${relationship.relationshipClass.targetItemClass}" />
                <form:errors path="targetItem" cssClass="error" />
            </ui:propertyItem>

            <c:forEach items="${relationship.attributeValues}" var="attributeValue" varStatus="status">
                <ui:propertyItem label="attributeValues${status.index}.value" caption="${attributeValue.attribute.name}">
                    <form:input path="attributeValues[${status.index}].value" />
                    <form:errors path="attributeValues[${status.index}].value" cssClass="error" />
                </ui:propertyItem>
            </c:forEach>

            <c:if test="${empty relationship.attributeValues}">
                <ui:propertyItem caption="field.cmdb.relationship.attributes">
                    <spring:message code="caption.cmdb.relationship.noattributes"/>
                </ui:propertyItem>
            </c:if>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
