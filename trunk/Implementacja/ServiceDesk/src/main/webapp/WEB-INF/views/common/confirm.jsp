<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<tiles:importAttribute name="fieldPrefix" ignore="true" />

<form:form method="post" modelAttribute="target">
    <ui:panel cssClass="messagebox confirm">
        <jsp:attribute name="caption">
            <tiles:getAsString name="caption" />
        </jsp:attribute>
        <jsp:body>
            <ui:errorList fieldPrefix="${fieldPrefix}"/>
            <p>
                <spring:message>
                    <jsp:attribute name="code">
                        <tiles:getAsString name="text" />
                    </jsp:attribute>
                    <jsp:attribute name="arguments">
                        <tiles:getAsString name="text_args" />
                    </jsp:attribute>
                </spring:message>
            </p>
            <p class="buttons">
                <ui:submit code="ok" name="submit" value="ok" cssClass="ok" />
                <ui:submit code="cancel" name="submit" value="cancel" cssClass="cancel" />
            </p>
        </jsp:body>
    </ui:panel>
</form:form>








