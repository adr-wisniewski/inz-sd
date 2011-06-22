/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.core.base.validation.AbstractValidator;
import servicedesk.core.base.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipClassAddValidator extends AbstractValidator<RelationshipClass> {

    @Autowired
    protected RelationshipClassService relationshipClassService;

    @Autowired
    protected EntityClassAddValidator entityClassAddValidator;

    @Override
    protected void doValidate(RelationshipClass target, Errors errors) {
        entityClassAddValidator.doValidate(target, errors);
        checkSimple(target, errors);
        ValidatorUtils.rejectNotUniqueName(target, errors, relationshipClassService, "validate.cmdb.relationship.class.name.notunique");
        checkLiskovSubstitution(target, errors);
    }

    private void checkSimple(RelationshipClass target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "label", "validate.cmdb.relationship.class.label.empty");
        ValidationUtils.rejectIfEmpty(errors, "sourceItemClass", "validate.cmdb.relationship.class.sourceItemClass.empty");
        ValidationUtils.rejectIfEmpty(errors, "targetItemClass", "validate.cmdb.relationship.class.targetItemClass.empty");
    }

    private void checkLiskovSubstitution(RelationshipClass target, Errors errors) {
        if(target.getParent() == null)
            return;

        if(target.getSourceItemClass() != null && !checkIsSameOrSubclass(target.getParent().getSourceItemClass(), target.getSourceItemClass()))
            errors.rejectValue("sourceItemClass",
                    "validate.cmdb.relationship.class.sourceItemClass.notSubstitutable",
                    new Object[]{target.getParent().getSourceItemClass().getName()},
                    "");

        if(target.getTargetItemClass() != null && !checkIsSameOrSubclass(target.getParent().getTargetItemClass(), target.getTargetItemClass()))
            errors.rejectValue("targetItemClass",
                    "validate.cmdb.relationship.class.targetItemClass.notSubstitutable",
                    new Object[]{target.getParent().getTargetItemClass().getName()},
                    "");

    }

    private boolean checkIsSameOrSubclass(ItemClass supposedParent, ItemClass supposedChild) {
        ItemClass current = supposedChild;

        while(current != null) {
            if(current.equals(supposedParent))
                return true;

            current = current.getParent();
        }

        return false;
    }
}
