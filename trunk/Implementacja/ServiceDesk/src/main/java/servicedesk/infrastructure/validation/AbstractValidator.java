/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.validation;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import servicedesk.infrastructure.interfaces.dao.AttachDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;
import servicedesk.infrastructure.interfaces.domain.NamedDomainObject;
import servicedesk.infrastructure.interfaces.service.NamedService;
import servicedesk.infrastructure.util.GenericUtil;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public abstract class AbstractValidator<Type> implements Validator {

    @SuppressWarnings("unchecked")
    private Class<Type> typeClass = (Class<Type>)GenericUtil
            .getTypeArgument(AbstractValidator.class, getClass(), 0);

    @Autowired
    protected AttachDao attachDao;
    
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
