/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.infrastructure.util.GenericUtil;

/**
 *
 * @author Adrian
 */
public abstract class AbstractValidator<Type> implements Validator {

    protected Class<Type> typeClass = (Class<Type>)GenericUtil
            .getTypeArgument(AbstractValidator.class, getClass(), 0);

    @Override
    public final boolean supports(Class<?> clazz) {
        return typeClass.isAssignableFrom(clazz);
    }

    @Override
    public final void validate(Object target, Errors errors) {
        doValidate((Type)target, errors);
    }

    protected abstract void doValidate(Type target, Errors errors);
}