/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

/**
 *
 * @author Adrian
 */
@Aspect
@Component// preauhorize is -1,
public class ValidatedAspect implements Ordered, ApplicationContextAware {

    protected ApplicationContext applicationContext;
    protected static final int ORDER = Ordered.LOWEST_PRECEDENCE; // run last

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Pointcut("execution(public * sd.service.*.*(..)) || execution(public * sd..service.*.*(..))")
    public void businessService() {
    }

    @Before("businessService() && @annotation(validated)")
    public void validate(JoinPoint jp, Validated validated) throws NoSuchMethodException {
        Object[] args = jp.getArgs();
        BindingResult bindingResult = getBindingResult(args, validated);
        Validator validator = getValidator(validated);
        doValidate(args[0], bindingResult, validator);
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

    private void doValidate(Object object, BindingResult bindingResult, Validator validator) {
        if(!validator.supports(object.getClass()))
            throw new IllegalArgumentException("@Validated validator must support method's first parameter type");

        validator.validate(object, bindingResult);

        if(bindingResult.hasErrors())
            throw new BusinessConstraintViolationException(bindingResult);
    }
}
