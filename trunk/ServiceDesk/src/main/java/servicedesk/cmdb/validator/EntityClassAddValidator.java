/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.cmdb.domain.EntityClass;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class EntityClassAddValidator extends AbstractValidator<EntityClass> {

    @Override
    protected void doValidate(EntityClass target, Errors errors) {
        checkSimple(target, errors);
        checkParentChain(target, errors);
    }

    protected void checkSimple(EntityClass target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.cmdb.entity.class.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.cmdb.entity.class.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "validate.cmdb.entity.class.abstraction.empty");
    }

    protected void checkParentChain(EntityClass target, Errors errors)
    {
        // cannot be parent to itself
        EntityClass parent = target.getParent();

        while(parent != null) {
            if(target.equals(parent)) {
                errors.rejectValue("parent", "validate.cmdb.entity.class.parent.recursive");
                break;
            }

            parent = parent.getParent();
        }
    }

}
