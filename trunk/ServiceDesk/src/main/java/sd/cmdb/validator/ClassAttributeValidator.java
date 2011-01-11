/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.service.ItemClassCrudService;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class ClassAttributeValidator extends AbstractValidator<ClassAttribute> {

    @Autowired
    protected ItemClassCrudService itemClassCrudService;

    @Override
    public void doValidate(ClassAttribute target, Errors errors) {
        checkSimple(target, errors);
        checkUniqueName(target, errors);
    }

    protected void checkSimple(ClassAttribute target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "cmdb.class.attribute.validate.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "cmdb.class.attribute.validate.description.empty");
    }

    private void checkUniqueName(final ClassAttribute target, Errors errors) {
        ItemClass itemClass = itemClassCrudService.get(target.getId().getClassId());

        // create predicate
        Predicate<ClassAttribute> predicate = new Predicate<ClassAttribute>() {
            @Override
            public boolean apply(ClassAttribute input) {
                return !input.getId().equals(target.getId())
                    && input.getName().equals(target.getName());
            }
        };

        // check both directions
        if (!uniqueNameUpwards(itemClass, predicate) || !uniqueNameDownwards(itemClass, predicate)) {
            errors.rejectValue("name", "cmdb.class.attribute.validate.name.notunique");
        }
    }

    private boolean uniqueNameAgainstClass(ItemClass itemClass, Predicate<ClassAttribute> predicate) {
        if(Iterables.any(itemClass.getAllAttributes(), predicate)) {
            return false;
        }

        return true;
    }

    private boolean uniqueNameUpwards(ItemClass itemClass, Predicate<ClassAttribute> predicate) {
        for(ItemClass reference = itemClass; reference != null; reference = reference.getParent()) {
            if(!uniqueNameAgainstClass(itemClass, predicate))
                return false;
        }

        return true;
    }

    private boolean uniqueNameDownwards(ItemClass itemClass, Predicate<ClassAttribute> predicate) {
        if(!uniqueNameAgainstClass(itemClass, predicate)) {
                return false;
        }

        for(ItemClass child : itemClass.getChildren()) {
            if(!uniqueNameDownwards(child, predicate))
                return false;
        }

        return true;
    }

}
