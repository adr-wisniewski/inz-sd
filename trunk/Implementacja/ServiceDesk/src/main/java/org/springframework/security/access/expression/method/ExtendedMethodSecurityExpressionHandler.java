/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.security.access.expression.method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrian
 */
@Component
public class ExtendedMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler  {
   
    protected ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
    protected PermissionEvaluator permissionEvaluator = new DenyAllPermissionEvaluator();
    protected AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private RoleHierarchy roleHierarchy;
    
    @Override
    public EvaluationContext createEvaluationContext(Authentication auth, MethodInvocation mi) {
        MethodSecurityEvaluationContext ctx = new MethodSecurityEvaluationContext(auth, mi, parameterNameDiscoverer);
        MethodSecurityExpressionRoot root = new ExtendedMethodSecurityExpressionRoot(auth);
        root.setTrustResolver(trustResolver);
        root.setPermissionEvaluator(permissionEvaluator);
        root.setRoleHierarchy(roleHierarchy);
        ctx.setRootObject(root);

        return ctx;
    }
    
    @Override
     public void setParameterNameDiscoverer(ParameterNameDiscoverer parameterNameDiscoverer) {
        this.parameterNameDiscoverer = parameterNameDiscoverer;
    }

    @Override
    public void setPermissionEvaluator(PermissionEvaluator permissionEvaluator) {
        this.permissionEvaluator = permissionEvaluator;
    }

    @Override
    public void setTrustResolver(AuthenticationTrustResolver trustResolver) {
        this.trustResolver = trustResolver;
    }

    @Override
    public void setRoleHierarchy(RoleHierarchy roleHierarchy) {
        this.roleHierarchy = roleHierarchy;
    }
  
}
