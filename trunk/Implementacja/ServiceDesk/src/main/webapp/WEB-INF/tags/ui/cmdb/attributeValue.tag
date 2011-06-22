<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="attribute" required="true" rtexprvalue="true" type="servicedesk.core.itil.cmdb.domain.Attribute"%>
<%@attribute name="entity" required="true" rtexprvalue="true" type="servicedesk.core.itil.cmdb.domain.Entity"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="entity.getAttributeValue(attribute)" var="attributeValue" />

<c:choose>
    <c:when test="${attributeValue.value != null}">
        ${attributeValue.value}
    </c:when>
    <c:otherwise>
        <em class="nullvalue"><spring:message code="caption.cmdb.item.nullvalue" /></em>
    </c:otherwise>
</c:choose>