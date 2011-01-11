/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import sd.cmdb.domain.ClassAttribute;
import sd.infrastructure.validation.AbstractCrudValidator;

/**
 *
 * @author Adrian
 */
@Component
public class ClassAttributeCrudValidator extends AbstractCrudValidator<ClassAttribute> {

    @Autowired
    protected ClassAttributeValidator classAttributeValidator;

    @Override
    protected void doValidateAdd(ClassAttribute object, BindingResult bindingResult) {
        classAttributeValidator.validate(object, bindingResult);
    }

    @Override
    protected void doValidateUpdate(ClassAttribute object, BindingResult bindingResult) {
        classAttributeValidator.validate(object, bindingResult);
    }

    @Override
    protected void doValidateDelete(ClassAttribute object, BindingResult bindingResult) {
        // do nothing
    }

}
