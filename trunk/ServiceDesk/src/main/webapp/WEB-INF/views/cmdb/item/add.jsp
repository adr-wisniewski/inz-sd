<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:panel caption="caption.cmdb.item.pickclass">
    <form:form modelAttribute="universalItem" method="post">
        <ui:errorList fieldPrefix="field.cmdb.item"/>
        <ui:propertyList>
            <ui:propertyItem code="field.cmdb.item.class" label="class">
                <sd:treePicker name="itemClass" value="${universalItem.itemClass}" source="itemclass_cmdb"/>
                <form:errors path="itemClass" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                <ui:submit code="add.label" cssClass="add" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
