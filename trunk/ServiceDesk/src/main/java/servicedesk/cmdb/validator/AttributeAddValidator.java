/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.validator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.cmdb.domain.Attribute;
import servicedesk.cmdb.domain.EntityClass;
import servicedesk.cmdb.service.UniversalItemClassService;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class AttributeAddValidator extends AbstractValidator<Attribute> {

    @Autowired
    protected UniversalItemClassService itemClassService;

    @Override
    protected void doValidate(Attribute target, Errors errors) {
        checkSimple(target, errors);
        checkUniqueName(target, errors);
    }

    protected void checkSimple(Attribute target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.cmdb.class.attribute.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.cmdb.class.attribute.description.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "displayNo", "validate.cmdb.class.attribute.displayNo.empty");
    }

    private void checkUniqueName(final Attribute target, Errors errors) {
        EntityClass entityClass = target.getEntityClass();

        // create predicate
        Predicate<Attribute> predicate = new Predicate<Attribute>() {
            @Override
            public boolean apply(Attribute input) {
                return !input.getId().equals(target.getId())
                    && input.getName().equals(target.getName());
            }
        };

        // check both directions
        if (!uniqueNameAgainstClass(entityClass, predicate) || !uniqueNameUpwards(entityClass, predicate) || !uniqueNameDownwards(entityClass, predicate)) {
            errors.rejectValue("name", "validate.cmdb.class.attribute.name.notunique");
        }
    }

    private boolean uniqueNameAgainstClass(EntityClass entityClass, Predicate<Attribute> predicate) {
        if(Iterables.any(entityClass.getAllAttributes(), predicate)) {
            return false;
        }

        return true;
    }

    private boolean uniqueNameUpwards(EntityClass entityClass, Predicate<Attribute> predicate) {
        for(EntityClass reference = entityClass.getParent(); reference != null; reference = reference.getParent()) {
            if(!uniqueNameAgainstClass(reference, predicate))
                return false;
        }

        return true;
    }

    private boolean uniqueNameDownwards(EntityClass entityClass, Predicate<Attribute> predicate) {
        for(EntityClass child : entityClass.getChildren()) {
            if(!uniqueNameAgainstClass(child, predicate) || !uniqueNameDownwards(child, predicate))
                return false;
        }

        return true;
    }

}
