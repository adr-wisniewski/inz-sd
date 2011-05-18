<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="submitLabel" />
<tiles:importAttribute name="submitCssClass" />

<ui:panel caption="fieldgroup.common.announcement.simple">
    <form:form modelAttribute="announcement" method="post">
        <ui:errorList fieldPrefix="field.common.announcement"/>
        <ui:propertyList>
            <ui:propertyItem code="field.common.announcement.title" label="title">
                <form:input path="title" />
                <form:errors path="title" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.common.announcement.content" label="content">
                <form:textarea path="content" />
                <form:errors path="content" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.common.announcement.publicationTime" label="publicationTime">
                <ui:datetimePicker name="publicationTime" value="${announcement.publicationTime}" />
                <form:errors path="publicationTime" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="${submitLabel}" cssClass="${submitCssClass}" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>
