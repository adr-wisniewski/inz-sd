<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>

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
        
        <ui:propertyItem code="field.change.rfc.author">
            <link:user object="${rfc.author}" />
        </ui:propertyItem>

        <ui:propertyItem code="field.change.rfc.creationTime">
             <print:datetime datetime="${rfc.timestamp}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.category">
            <link:rfcCategory object="${rfc.category}" />
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

        
        <ui:propertyItem code="field.change.rfc.manager">
             <link:employee object="${rfc.manager}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.builder">
            <link:employee object="${rfc.builder}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.authority">
            <link:rfcAuthority object="${rfc.authority}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.cab">
            <link:rfcAuthority object="${rfc.cab}" />
        </ui:propertyItem>
        
        <ui:propertyItem code="field.change.rfc.pir">
            ${rfc.pir}
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

<ui:panel caption="caption.change.rfc.related">
    <cmdb:relatedItems item="${rfc.rfcItem}" relationships="${relationships}" />
</ui:panel>
    
<ui:panel caption="caption.change.rfc.actions">
    <form:form modelAttribute="rfc" method="post">
        <div class="radiobar">
        <script type="text/javascript">  
            $(function() {
                $(".prop").hide();
                $("[name=action]").click(function(){
                    var cls = "." + $(this).val();
                    $(".prop").not(cls).hide();
                    $(".prop"+cls).show();
                });
            })
        </script>
        
        <c:if test="${(isAuthor and (rfc.state eq 'NEW' or rfc.state eq 'REJECTED')) or isManager}">
            <label for="action-update">
                <input type="radio" id="action-update" name="action" value="update" l>
                <spring:message code="caption.change.rfc.update" />
            </label>
        </c:if>  
        
        <security:authorize ifAnyGranted="CHANGE_RFC_MANAGE">
            <c:if test="${empty rfc.manager}">
                <label for="action-assignToSelf">
                    <input type="radio" id="action-assignToSelf" name="action" value="assignToSelf"/>
                    <spring:message code="caption.change.rfc.assignToSelf" />
                </label>
            </c:if>
        </security:authorize>
                
        <security:authorize ifAnyGranted="CHANGE_RFC_ASSIGN">
            <label for="action-assign">
                <input type="radio" id="action-assign" name="action" value="assign" />
                <spring:message code="caption.change.rfc.assign" />
            </label>
        </security:authorize>   
 
        <c:if test="${rfc.state eq 'ASSIGNED' and isManager}">
            <label for="action-review">
                <input type="radio" id="action-review" name="action" value="review"/>
                <spring:message code="caption.change.rfc.review" />
            </label>
        </c:if>    
            
        <c:if test="${rfc.state eq 'REVIEWED' and isManager}">   
            <label for="action-assess">
                <input type="radio" id="action-assess" name="action" value="assess"/>
                <spring:message code="caption.change.rfc.assess" />
            </label>
        </c:if>  
            
        <c:if test="${rfc.state eq 'ASSESSED' and isAuthority}">    
            <label for="action-authorize">
                <input type="radio" id="action-authorize" name="action" value="authorize" />
                <spring:message code="caption.change.rfc.authorize" />
            </label>
        </c:if>  
            
        <c:if test="${rfc.state eq 'AUTHORIZED' and isCabMember}">    
            <label for="action-schedule">
                <input type="radio" id="action-schedule" name="action" value="schedule" />
                <spring:message code="caption.change.rfc.schedule" />
            </label>
        </c:if>  
            
        <c:if test="${rfc.state eq 'SCHEDULED' and isBuilder}">    
            <label for="action-build">
                <input type="radio" id="action-build" name="action" value="build"/>
                <spring:message code="caption.change.rfc.build" />
            </label>
        </c:if>  
            
        <c:if test="${rfc.state eq 'BUILT' and isManager}">
            <label for="action-close">
            <input type="radio" id="action-close" name="action" value="close"/>
                <spring:message code="caption.change.rfc.close" />
            </label>
        </c:if>    
            
        <c:if test="${rfc.state ne 'REJECTED' and rfc.state ne 'CLOSED' and isManager}">
            <label for="action-reject">
                <input type="radio" id="action-reject" name="action" value="reject"/>
                <spring:message code="caption.change.rfc.reject" />
            </label>
        </c:if> 
            
        <c:if test="${rfc.state eq 'REJECTED' and not isManager}">  
            <label for="action-appeal">
                <input type="radio" id="action-appeal" name="action" value="appeal"/>
                <spring:message code="caption.change.rfc.appeal" />
            </label>
        </c:if> 
        
        <c:if test="${rfc.state eq 'APPEALED' and isManager}">  
            <label for="action-acceptAppeal">
                <input type="radio" id="action-acceptAppeal" name="action" value="acceptAppeal"/>
                <spring:message code="caption.change.rfc.acceptAppeal" />
            </label>
        </c:if> 
        
        <label for="action-addComment">
        <input type="radio" id="action-addComment" name="action" value="addComment" checked="checked" />
            <spring:message code="caption.change.rfc.addComment" />
        </label>  
        </div>
            
        <ui:errorList fieldPrefix="field.change.rfc"/>
        <ui:propertyList>
            
            <ui:propertyItem code="field.change.rfc.title" label="title" cssClass="prop update appeal">
                <form:input path="title" />
                <form:errors path="title" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.description" label="description" cssClass="prop update appeal">
                <form:textarea path="description" />
                <form:errors path="description" cssClass="error" />
            </ui:propertyItem>
            
             <ui:propertyItem code="field.change.rfc.category" label="category" cssClass="prop review assess authorize">
                <sd:treePicker name="category" value="${rfc.category}" source="rfcCategoriesTree" />
                <form:errors path="category" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.priority" label="priority" cssClass="prop review assess authorize">
                <form:select path="priority" itemLabel="name" itemValue="id" items="${priorities}" />
                <form:errors path="priority" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem code="field.change.rfc.impact" label="impact" cssClass="prop assess authorize">
                <form:select path="impact" itemLabel="name" itemValue="id" items="${impacts}" />
                <form:errors path="impact" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.resolution" label="resolution" cssClass="prop reject close">
                <form:select path="resolution" itemLabel="name" itemValue="id" items="${resolutions}" />
                <form:errors path="resolution" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.manager" label="manager" cssClass="prop assign">
                <sd:employeePicker name="manager" value="${rfc.manager}" />
                <form:errors path="manager" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.builder" label="builder" cssClass="prop schedule">
                <sd:employeePicker name="builder" value="${rfc.builder}" />
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.authority" label="authority" cssClass="prop assess">
                <form:select multiple="true" path="authority" itemLabel="name" itemValue="id" items="${authorities}" />
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.cab" label="cab" cssClass="prop assess" >
                <form:select multiple="true" path="cab" itemLabel="name" itemValue="id" items="${cabs}" />
                <form:errors path="builder" cssClass="error"/>
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.pir" label="pir" cssClass="prop close">
                <form:textarea path="pir" />
                <form:errors path="pir" cssClass="error" />
            </ui:propertyItem>
            
            <ui:propertyItem code="field.change.rfc.comment" label="comment">
                <form:textarea path="comment" />
                <form:errors path="comment" cssClass="error" />
            </ui:propertyItem>

            <ui:propertyItem>
                 <ui:submit code="submit.label" cssClass="goto" />
            </ui:propertyItem>
        </ui:propertyList>
    </form:form>
</ui:panel>

<ui:panel caption="fieldgroup.change.rfc.history">
    <c:forEach items="${changes}" var="change">
        <c:if test="${change.properitiesChanged or change.commentChanged}">
        <div class="rfc change">
            <div class="signature">
                <link:user object="${change.instigator}"/> <print:datetime datetime="${change.timestamp}" />
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

                <c:if test="${change.category.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.category.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                        <print:nullable object="${change.category.previousValue}">
                            ${change.category.previousValue.name}
                        </print:nullable>
                        </span>

                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                        <print:nullable object="${change.category.nextValue}">
                            ${change.category.nextValue.name}
                        </print:nullable>
                        </span>
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
                    
                    <c:if test="${change.resolution.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.resolution.changed" />
                        </span>

                        <spring:message code="caption.change.rfc.changed.from" />
                        <span class="oldvalue">
                        <print:nullable object="${change.resolution.previousValue}">
                            ${change.resolution.previousValue.name}
                        </print:nullable>
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                        <print:nullable object="${change.resolution.nextValue}">
                            ${change.resolution.nextValue.name}
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
                    
                <c:if test="${change.builder.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.builder.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />

                        <span class="oldvalue">
                            <link:employee object="${change.builder.previousValue}" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                            <link:employee object="${change.builder.nextValue}" />
                        </span>
                    </li>
                </c:if>
                    
                <c:if test="${change.authority.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.authority.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />

                        <span class="oldvalue">
                            <link:rfcAuthority object="${change.authority.previousValue}" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                            <link:rfcAuthority object="${change.authority.nextValue}" />
                        </span>
                    </li>
                </c:if>
                    
                <c:if test="${change.cab.changed}">
                    <li>
                        <span class="changedelement">
                        <spring:message code="field.change.rfc.cab.changed" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.from" />

                        <span class="oldvalue">
                            <link:rfcAuthority object="${change.cab.previousValue}" />
                        </span>
                        <spring:message code="caption.change.rfc.changed.to" />
                        <span class="newvalue">
                            <link:rfcAuthority object="${change.cab.nextValue}" />
                        </span>
                    </li>
                </c:if>
                    
                <c:if test="${change.pir.changed}">
                    <li>
                        <spring:message code="field.change.rfc.pir.changed" />
                    </li>
                </c:if>
            </ul>
            </c:if>
            
            <c:if test="${change.commentChanged}">
            <div class="comment">
                <span class="changedelement">
                <spring:message code="field.change.rfc.comment.changed" />
                </span>
                <br/>
                ${change.comment.nextValue}
            </div>
            </c:if>
        </div>
        </c:if>
    </c:forEach>
</ui:panel>