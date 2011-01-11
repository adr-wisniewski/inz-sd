/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import sd.cmdb.domain.ClassAttribute;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class ClassAttributeDeleteableValidator extends AbstractValidator<ClassAttribute> {

    @Override
    protected void doValidate(ClassAttribute target, Errors errors) {
        checkIsUsed(target, errors);
    }

    private void checkIsUsed(ClassAttribute target, Errors errors) {
        // TODO: finish this
    }

}
