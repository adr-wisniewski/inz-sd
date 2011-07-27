<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>

<ui:panel caption="fieldgroup.change.rfc.basic">
    <ui:propertyList>
        <ui:propertyItem code="field.change.rfc.id">
            ${rfc.id}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.title">
            ${rfc.title}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.description">
            ${rfc.description}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.priority">
             <print:nullable object="${rfc.priority}">
                 ${rfc.priority.name}
             </print:nullable>
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.impact">
            <print:nullable object="${rfc.impact}">
                 ${rfc.impact.name}
            </print:nullable>
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.state">
            ${rfc.state.name}
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.creator">
            <link:employee object="${rfc.creator}" />
        </ui:propertyItem>

         <ui:propertyItem code="field.change.rfc.creationTime">
             <print:datetime datetime="${rfc.timestamp}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.manager">
             <link:employee object="${rfc.manager}" />
        </ui:propertyItem>
    </ui:propertyList>
    <p class="buttons">
        <ui:actionButton label="edit.label"
                         action="/change/rfc/${rfc.id}/edit"
                         cssClass="edit"
                         role="CHANGE_RFC_EDIT" />

        <ui:actionButton label="delete.label"
                         action="/change/rfc/${rfc.id}/delete"
                         cssClass="delete"
                         role="CHANGE_RFC_DELETE"/>
    </p>
</ui:panel>

<ui:panel caption="caption.change.rfc.actions">
    <form:form modelAttribute="rfc" method="post" action="/change/rfc/${rfc.id}/addComment">
        <ui:errorList fieldPrefix="field.change.rfc"/>
        <ui:propertyList>
            <ui:propertyItem code="field.change.rfc.comment" label="comment">
                <form:textarea path="comment" />
                <form:errors path="comment" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem>
                 <ui:submit code="add.label" cssClass="add" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>

<ui:panel caption="fieldgroup.change.rfc.history">
    <c:forEach items="${changes}" var="change">
        <div class="rfc change">
            <div class="signature">
                <link:employee object="${change.instigator}"/> <print:datetime datetime="${change.timestamp}" />
            </div>
            
            <c:if test="${change.created}">
            <div class="state">
                <spring:message code="caption.change.rfc.created" /> 
            </div>        
            </c:if>
        
            <c:if test="${change.properitiesChanged}">
            <ul class="properties">
                <c:if test="${change.title.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.title.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                            <print:nullable object="${change.title.previousValue}">
                                ${change.title.previousValue}
                            </print:nullable>
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                            <print:nullable object="${change.title.nextValue}">
                                ${change.title.nextValue}
                            </print:nullable>
                        </span>
                    </li>
                </c:if>
                
                <c:if test="${change.description.changed}">
                    <li>
                        <spring:message code="field.change.rfc.description.changed" />
                    </li>
                </c:if>
                
                <c:if test="${change.priority.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.priority.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                        <print:nullable object="${change.priority.previousValue}">
                            ${change.priority.previousValue.name}
                        </print:nullable>
                        </span>

                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                        <print:nullable object="${change.priority.nextValue}">
                            ${change.priority.nextValue.name}
                        </print:nullable>
                        </span>
                    </li>
                </c:if>
                
                <c:if test="${change.impact.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.impact.changed" />
                        </span>

                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                        <print:nullable object="${change.impact.previousValue}">
                            ${change.impact.previousValue.name}
                        </print:nullable>
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                        <print:nullable object="${change.impact.nextValue}">
                            ${change.impact.nextValue.name}
                        </print:nullable>
                        </span>
                    </li>
                </c:if>
                
                <c:if test="${change.state.changed}">
                    <li>
                        <span class="changedelement">
                            <spring:message code="field.change.rfc.state.changed" />
                        </span>

                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                        <print:nullable object="${change.state.previousValue}">
                            ${change.state.previousValue.name}
                        </print:nullable>
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                        <print:nullable object="${change.state.nextValue}">
                            ${change.state.nextValue.name}
                        </print:nullable>
                        </span>
                    </li>
                </c:if>
                
                <c:if test="${change.manager.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.manager.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />

                        <span class="oldvalue">
                            <link:employee object="${change.manager.previousValue}" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                            <link:employee object="${change.manager.nextValue}" />
                        </span>
                    </li>
                </c:if>
            </ul>
            </c:if>
            
            <c:if test="${change.comment.changed}">
            <div class="comment">
                ${change.comment.nextValue}
            </div>
            </c:if>
        </div>
    </c:forEach>
</ui:panel>