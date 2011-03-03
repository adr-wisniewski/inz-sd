/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.cmdb.domain.UniversalItemClass;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class UniversalItemClassDeleteValidator extends AbstractValidator<UniversalItemClass> {

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        hasNoChildrenClasses(target, errors);
        hasNoInstances(target, errors);
        isNotUsedByRelationships(target, errors);
    }

    protected void hasNoChildrenClasses(UniversalItemClass itemClass, Errors errors)
    {
        if(itemClass.getChildren().size() > 0)
            errors.reject("validate.cmdb.item.class.deleteable.haschildren");
    }

    protected void hasNoInstances(UniversalItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("validate.cmdb.item.class.deleteable.hasinstances");
    }

    protected void isNotUsedByRelationships(UniversalItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("validate.cmdb.item.class.deleteable.usedbyrelationship", Object[] relationship.getName());
    }

}
