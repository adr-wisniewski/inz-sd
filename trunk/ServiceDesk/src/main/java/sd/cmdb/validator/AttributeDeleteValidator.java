/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import sd.cmdb.domain.Attribute;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class AttributeDeleteValidator extends AbstractValidator<Attribute> {

    @Override
    protected void doValidate(Attribute target, Errors errors) {
        checkIsUsed(target, errors);
    }

    private void checkIsUsed(Attribute target, Errors errors) {
        // TODO: finish this
    }

}
