/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.validation;

import java.io.Serializable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import servicedesk.infrastructure.general.dao.NamedDao;
import servicedesk.infrastructure.general.domain.NamedDomainObject;
import servicedesk.infrastructure.general.service.NamedService;
import servicedesk.infrastructure.general.util.GenericUtil;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public abstract class AbstractValidator<Type> implements Validator {

    @SuppressWarnings("unchecked")
    private Class<Type> typeClass = (Class<Type>)GenericUtil
            .getTypeArgument(AbstractValidator.class, getClass(), 0);

    @Override
    public final boolean supports(Class<?> clazz) {
        return typeClass.isAssignableFrom(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void validate(Object target, Errors errors) {
        doValidate((Type)target, errors);
    }

    protected abstract void doValidate(Type target, Errors errors);
}
