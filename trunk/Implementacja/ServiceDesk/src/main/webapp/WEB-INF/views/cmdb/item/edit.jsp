<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="caption.cmdb.item.attributes">
    <form:form modelAttribute="universalItem" method="post">
        <ui:errorList fieldPrefix="field.cmdb.item"/>
        <ui:propertyList>

            <ui:propertyItem code="field.cmdb.item.label" label="label">
                <form:checkbox path="label" />
                <form:errors path="label" cssClass="error" />
            </ui:propertyItem>

            <c:forEach items="${universalItem.attributeValues}" var="attributeValue" varStatus="status">
                <ui:propertyItem label="attributeValues${status.index}.value" caption="${attributeValue.attribute.name}">
                    <form:input path="attributeValues[${status.index}].value" />
                    <form:errors path="attributeValues[${status.index}].value" cssClass="error" />
                </ui:propertyItem>
            </c:forEach>

            <c:if test="${empty universalItem.attributeValues}">
                <ui:propertyItem>
                    <spring:message code="caption.cmdb.item.noattributes"/>
                </ui:propertyItem>
            </c:if>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
