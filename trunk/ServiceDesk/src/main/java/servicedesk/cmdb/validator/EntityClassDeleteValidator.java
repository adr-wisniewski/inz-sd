/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.cmdb.domain.EntityClass;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class EntityClassDeleteValidator extends AbstractValidator<EntityClass> {

    @Override
    protected void doValidate(EntityClass target, Errors errors) {
        hasNoChildrenClasses(target, errors);
    }

    protected void hasNoChildrenClasses(EntityClass itemClass, Errors errors)
    {
        if(itemClass.getChildren().size() > 0)
            errors.reject("validate.cmdb.entity.class.deleteable.haschildren");
    }

}
