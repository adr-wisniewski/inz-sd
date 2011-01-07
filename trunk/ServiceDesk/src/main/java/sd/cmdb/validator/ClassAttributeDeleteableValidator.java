/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.service.ClassServiceFacade;

/**
 *
 * @author Adrian
 */
@Component
public class ClassAttributeDeleteableValidator implements Validator {
    @Autowired
    protected ClassServiceFacade clazzService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ClassAttribute.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO: add delete attribute constraints
    }
}
