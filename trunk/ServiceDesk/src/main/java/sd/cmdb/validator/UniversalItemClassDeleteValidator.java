/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import sd.cmdb.domain.UniversalItemClass;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class UniversalItemClassDeleteValidator extends AbstractValidator<UniversalItemClass> {

    @Autowired
    protected EntityClassDeleteValidator entityClassDeleteValidator;

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        entityClassDeleteValidator.doValidate(target, errors);
        hasNoInstances(target, errors);
        isNotUsedByRelationships(target, errors);
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
