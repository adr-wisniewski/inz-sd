/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import servicedesk.infrastructure.interfaces.dao.AttachDao;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Aspect
@Component// preauhorize is -1,
public class ValidatedAspect implements Ordered, ApplicationContextAware {

    protected ApplicationContext applicationContext;
    protected static final int ORDER = Ordered.LOWEST_PRECEDENCE; // run last

    @Autowired
    protected AttachDao dao;
    
    
    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Pointcut("execution(public * servicedesk..service.*.*(..))")
    public void businessService() {
    }

    @Before("businessService() && @annotation(validated)")
    public void validate(JoinPoint jp, Validated validated) throws NoSuchMethodException {
        Object[] args = jp.getArgs();
        
        if(args.length == 0)
            throw new IllegalArgumentException("At least 1 argument required for @validated method!");
        
        Object target = args[0];
        if(!(target instanceof DomainObject<?>)) 
            throw new IllegalArgumentException("1st argument of @validated method must be a domain object");
        
        BindingResult bindingResult = getBindingResult(args, validated);
        Validator validator = getValidator(validated);
        
        
        
        doValidate((DomainObject<?>)target, bindingResult, validator);
    }

    private BindingResult getBindingResult(Object[] args, Validated validated) {
        if(args.length == 1 ) {
            String bindName = validated.name();
            return new BeanPropertyBindingResult(args[0], bindName);
        }
        else if(args.length == 2) {
            if(!(args[1] instanceof BindingResult))
                throw new IllegalArgumentException("@Validated method's second parameter should be BindingResult");

            return (BindingResult)args[1];
        }
        else {
            throw new IllegalArgumentException("@Validated method should have 1 or 2 parameters");
        }
    }

    private Validator getValidator(Validated validated) {
        return (Validator)BeanFactoryUtils.beanOfTypeIncludingAncestors(applicationContext, validated.validator());
    }

    @Transactional(readOnly=true)
    private void doValidate(DomainObject<?> object, BindingResult bindingResult, Validator validator) {
        if(!validator.supports(object.getClass()))
            throw new IllegalArgumentException("@Validated validator must support method's first parameter type");

        dao.attach(object);
        validator.validate(object, bindingResult);
        dao.detach(object);

        if(bindingResult.hasErrors())
            throw new BusinessConstraintViolationException(bindingResult);
    }
}
