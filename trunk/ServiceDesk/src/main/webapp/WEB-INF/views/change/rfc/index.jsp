<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:hint code="hint.cmdb.namesearch" />

<ui:element>
    <form:form modelAttribute="rfcCriteria" method="get">
        <form:errors path="*" cssClass="error" />
        <script type="text/javascript">   
            $.tablesorter.addParser({  
               id: "rfc_priority",  
               is: function(s) {  
                   return false;  
               },
               _values: {
                    <c:forEach items="${priorities}" var="priority">
                    "${priority.name}": ${priority.order},         
                    </c:forEach>
               },
               format: function(s) {  
                   return this._values[$.trim(s)];
               },  
               type: "numeric"  
            });
            
            $.tablesorter.addParser({  
               id: "rfc_impact",  
               is: function(s) {  
                   return false;  
               },  
               values: {
                    <c:forEach items="${impacts}" var="impacts">
                    "${impacts.name}": ${impacts.order},         
                    </c:forEach>
               },
               format: function(s) {  
                   return this._values[$.trim(s)];
               },  
               type: "numeric"  
            });
            
            $.tablesorter.addParser({  
               id: "rfc_state",  
               is: function(s) {  
                   return false;  
               },
               values: {
                    <c:forEach items="${states}" var="state">
                    "${state.name}": ${state.id},         
                    </c:forEach>
               },
               format: function(s) {  
                   return this._values[$.trim(s)];
               },  
               type: "numeric"  
            });  
            
            $.tablesorter.addParser({  
               id: "rfc_resolution",  
               is: function(s) {  
                   return false;  
               },  
               values: {
                    <c:forEach items="${resolutions}" var="resolution">
                    "${resolution.name}": ${resolution.order},         
                    </c:forEach>
               },
               format: function(s) {  
                   return this._values[$.trim(s)];
               },  
               type: "numeric"  
            }); 
            
            jQuery(function(){
                $(".custom.tablesorter.rfcs").tablesorter({   
                    widgets: ['zebra'],
                    headers: {
                        4 : { sorter : 'rfc_state' },
                        5 : { sorter : 'rfc_priority' }, 
                        6 : { sorter : 'rfc_impact' },
                        7 : { sorter : 'rfc_resolution' },
                    }
                });
            });
        </script> 
        <table class="custom tablesorter rfcs">
            <thead>
                <tr>
                    <th class="fit"><spring:message code="field.change.rfc.id" /></th>
                    <th><spring:message code="field.change.rfc.category" /></th>
                    <th><spring:message code="field.change.rfc.title" /></th>
                    <th><spring:message code="field.change.rfc.description" /></th>
                    <th class="fit"><spring:message code="field.change.rfc.state" /></th>
                    <th class="fit"><spring:message code="field.change.rfc.priority" /></th>
                    <th class="fit"><spring:message code="field.change.rfc.impact" /></th>
                    <th class="fit"><spring:message code="field.change.rfc.resolution" /></th>
                    <th class="fit noSort"><spring:message code="caption.actions" /></th>
                </tr>
                <tr>
                    <td>
                        <form:input path="id" />
                        <form:errors path="id" cssClass="error" />
                    </td>
                    <td>
                        <sd:treePicker name="category" value="${rfcCriteria.category}" source="rfccategory_change"/>
                        <form:errors path="category" cssClass="error" />
                    </td>
                    <td>
                        <form:input path="title" />
                        <form:errors path="title" cssClass="error" />
                    </td>
                    <td>
                        <form:input path="description" />
                        <form:errors path="description" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="state">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${states}" />
                        </form:select>
                        <form:errors path="state" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="priority">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${priorities}" />
                        </form:select>
                        <form:errors path="priority" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="impact">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${impacts}" />
                        </form:select>
                        <form:errors path="impact" cssClass="error" />
                    </td>
                    <td>
                        <form:select path="resolution">
                            <form:option label="" value="" />
                            <form:options itemLabel="name" itemValue="id" items="${resolutions}" />
                        </form:select>
                        <form:errors path="resolution" cssClass="error" />
                    </td>
                    <td>
                        <input type="submit" value="<spring:message code="search.label" />" class="button" />
                    </td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${rfcs}" var="rfc">
                    <tr>
                        <td>
                            ${rfc.id}
                        </td>
                        <td>
                            <print:nullable object="${rfc.category}">
                                ${rfc.category.name}
                            </print:nullable>
                        </td>
                        <td>
                            ${rfc.title}
                        </td>
                        <td>
                            ${rfc.description}
                        </td>
                        <td>
                            ${rfc.state.name}
                        </td>
                        <td>
                            <print:nullable object="${rfc.priority}">
                                ${rfc.priority.name}
                            </print:nullable>
                        </td>
                        <td>
                            <print:nullable object="${rfc.impact}">
                                ${rfc.impact.name}
                            </print:nullable>
                        </td>
                        <td>
                            <print:nullable object="${rfc.resolution}">
                                ${rfc.resolution.name}
                            </print:nullable>
                        </td>
                        <td class="actions">
                            <ui:actionButton label="details.label"
                                action="/change/rfc/${rfc.id}"
                                cssClass="details"/>
                        </td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${not rfcCriteria.initialized}">
                        <tr>
                            <td colspan="9">
                                <spring:message code="caption.query_empty" />
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${empty rfcs}">
                        <tr>
                            <td colspan="9">
                                <spring:message code="no_result.label" />
                            </td>
                        </tr>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </form:form>
</ui:element>