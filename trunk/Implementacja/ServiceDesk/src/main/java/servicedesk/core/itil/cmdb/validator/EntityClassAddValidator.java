/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.validator;

import javax.xml.bind.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.cmdb.domain.EntityClass;
import servicedesk.infrastructure.validation.AbstractValidator;
import servicedesk.infrastructure.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
@Component
public class EntityClassAddValidator extends AbstractValidator<EntityClass> {

    @Override
    protected void doValidate(EntityClass target, Errors errors) {
        checkSimple(target, errors);
        ValidatorUtils.rejectParentRecursive(target, errors, "validate.cmdb.entity.class.parent.recursive");
    }

    protected void checkSimple(EntityClass target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.cmdb.entity.class.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.cmdb.entity.class.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "validate.cmdb.entity.class.abstraction.empty");
    }
}
