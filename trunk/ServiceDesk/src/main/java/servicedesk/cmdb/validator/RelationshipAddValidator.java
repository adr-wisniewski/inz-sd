/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.Relationship;
import servicedesk.cmdb.domain.helper.EntityClassUtils;
import servicedesk.cmdb.service.RelationshipService;
import servicedesk.infrastructure.general.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipAddValidator extends AbstractValidator<Relationship> {

    @Autowired
    protected RelationshipService relationshipService;

    @Override
    protected void doValidate(Relationship target, Errors errors) {
        checkSimple(target, errors);
        checkUnique(target, errors);
        checkClassConstraints(target, errors);
    }

    private void checkSimple(Relationship target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "relationshipClass", "validate.cmdb.relationship.sourceItemClass.relationshipClass");
        ValidationUtils.rejectIfEmpty(errors, "sourceItem", "validate.cmdb.relationship.sourceItemClass.sourceItem");
        ValidationUtils.rejectIfEmpty(errors, "targetItem", "validate.cmdb.relationship.targetItemClass.targetItem");
    }

    protected void checkUnique(Relationship target, Errors errors) {
        Relationship same = relationshipService.getSame(target);
        if(same != null && !same.getId().equals(target.getId()))
            errors.reject("validate.cmdb.relationship.notunique");
    }

    private void checkClassConstraints(Relationship target, Errors errors) {


        if(target.getSourceItem() != null && !EntityClassUtils.isSameOrSubclass(target.getRelationshipClass().getSourceItemClass(), target.getSourceItem().getItemClass()))
            ValidationUtils.rejectIfEmpty(errors, "sourceItem", "validate.cmdb.relationship.sourceItem.badclass");

        if(target.getTargetItem() != null && !EntityClassUtils.isSameOrSubclass(target.getRelationshipClass().getTargetItemClass(),target.getTargetItem().getItemClass()))
            ValidationUtils.rejectIfEmpty(errors, "targetItem", "validate.cmdb.relationship.targetItem.badclass");
   }
}
