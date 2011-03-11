/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.UniversalItem;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class UniversalItemPreAddValidator extends AbstractValidator<UniversalItem> {

    @Override
    protected void doValidate(UniversalItem target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "itemClass", "validate.cmdb.item.itemClass.empty");

        checkAbstract(target, errors);
    }

    protected void checkAbstract(UniversalItem target, Errors errors) {
        if(target.getItemClass() == null)
            return;

        if(target.getItemClass().isAbstraction())
            errors.rejectValue("itemClass", "validate.cmdb.item.itemClass.abstract");
    }
}
