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
public class UniversalItemClassUpdateValidator extends AbstractValidator<UniversalItemClass> {

    @Autowired
    protected UniversalItemClassAddValidator ItemClassAddValidator;

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        ItemClassAddValidator.validate(target, errors);
        checkParentChanged(target, errors);
    }

    private void checkParentChanged(UniversalItemClass itemClass, Errors errors)
    {
        /*UniversalItemClass reference = clazzService.getItemClassById(itemClass.getIdentifier());

        // parent wasn't changed, skip
        if(itemClass.getParent() == reference.getParent())
            return;

        if(reference.getChildren().size() > 0)
            errors.rejectValue("parent", "validate.cmdb.item.class.editable.haschildren");

        // sanitize parent value
        itemClass.setParent(reference.getParent());*/
    }
}
