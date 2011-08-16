<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="cmdb" tagdir="/WEB-INF/tags/ui/cmdb" %>
<%@ taglib prefix="print" tagdir="/WEB-INF/tags/print" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/link" %>

<ui:panel caption="fieldgroup.common.user.simple">
    <ui:propertyList>
        <ui:propertyItem code="field.common.user.firstname">
            ${user.firstname}
        </ui:propertyItem>

        <ui:propertyItem code="field.common.user.lastname">
            ${user.lastname}
        </ui:propertyItem>
        
        <c:set var="person" value="${user.person}" />
        
        <c:if test="${type eq 'employee'}">
            <ui:propertyItem code="field.common.employeeUser.phoneNumber">
                ${person.phoneNumber}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.employeeUser.mobilePhone">
                ${person.mobilePhone}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.employeeUser.email">
                ${person.email}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.employeeUser.job">
                ${person.job.title}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.employeeUser.department">
                ${person.department.name}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.employeeUser.manager">
                <link:user object="${person.manager}" />
            </ui:propertyItem>        
            
        </c:if>
        
        <c:if test="${type eq 'client'}">
            <ui:propertyItem code="field.common.clientUser.phoneNumber">
                ${person.phoneNumber}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.clientUser.mobilePhone">
                ${person.mobilePhone}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.clientUser.email">
                ${person.email}
            </ui:propertyItem>
        </c:if>
        
        <c:if test="${type eq 'cooperant'}">
            <ui:propertyItem code="field.common.cooperantUser.phoneNumber">
                ${person.phoneNumber}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.cooperantUser.mobilePhone">
                ${person.mobilePhone}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.cooperantUser.email">
                ${person.email}
            </ui:propertyItem>
            
            <ui:propertyItem code="field.common.cooperantUser.organization">
                ${person.organization.name}
            </ui:propertyItem>
        </c:if>
    </ui:propertyList>
</ui:panel>