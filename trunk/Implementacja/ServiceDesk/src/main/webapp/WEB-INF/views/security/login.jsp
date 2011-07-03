<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<c:if test="${not empty param.login_error}">
    <ui:errorBox caption="message.security.login.failed">
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
    </ui:errorBox>
</c:if>

<ui:panel caption="message.security.login">
    <form name="f" action="<c:url value='/doLogin'/>" method="POST">
        <ui:propertyList>
            <ui:propertyItem code="field.security.username" label="j_username">
                <input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
            </ui:propertyItem>
            <ui:propertyItem code="field.security.password" label="j_password">
                <input type='password' name='j_password'>
            </ui:propertyItem>    
            <ui:propertyItem code="field.security.rememberme" label="_spring_security_remember_me">
                <input type="checkbox" name="_spring_security_remember_me" />
            </ui:propertyItem>     
            <ui:propertyItem>
                 <ui:submit code="caption.security.login" cssClass="login" />
            </ui:propertyItem>
        </ui:propertyList>    
    </form>  
</ui:panel>