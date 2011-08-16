<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:panel caption="caption.cmdb.relationship.properties">
    <ui:propertyList>
        <ui:propertyItem code="field.cmdb.relationship.sourceItem" label="sourceItem">
            <link:item object="${relationship.sourceItem}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.cmdb.relationship.targetItem" label="targetItem">
            <link:item object="${relationship.targetItem}" />
        </ui:propertyItem>

        <c:forEach items="${relationship.attributeValues}" var="attributeValue" varStatus="status">
            <ui:propertyItem caption="${attributeValue.attribute.name}">
                <c:out value="attributeValues[${status.index}].value" />
            </ui:propertyItem>
        </c:forEach>

        <c:if test="${empty relationship.attributeValues}">
            <ui:propertyItem caption="field.cmdb.relationship.attributes">
                <spring:message code="caption.cmdb.relationship.noattributes"/>
            </ui:propertyItem>
        </c:if>
    </ui:propertyList>
</ui:panel>
