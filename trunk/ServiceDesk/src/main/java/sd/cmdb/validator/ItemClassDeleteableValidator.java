/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class ItemClassDeleteableValidator extends AbstractValidator<ItemClass> {

    @Override
    public void doValidate(ItemClass target, Errors errors) {
        hasNoChildrenClasses(target, errors);
        hasNoInstances(target, errors);
        isNotUsedByRelationships(target, errors);
    }

    protected void hasNoChildrenClasses(ItemClass itemClass, Errors errors)
    {
        if(itemClass.getChildren().size() > 0)
            errors.reject("cmdb.item.class.validate.deleteable.haschildren");
    }

    protected void hasNoInstances(ItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("cmdb.item.class.validate.deleteable.hasinstances");
    }

    protected void isNotUsedByRelationships(ItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("cmdb.item.class.validate.deleteable.usedbyrelationship", Object[] relationship.getName());
    }

}
