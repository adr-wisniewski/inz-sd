/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Component
public class ItemClassUpdateableValidator extends ItemClassValidator {


    @Override
    public void doValidate(ItemClass target, Errors errors) {
        super.validate(target, errors);

        checkParentChanged(target, errors);
    }

    private void checkParentChanged(ItemClass itemClass, Errors errors)
    {
        /*ItemClass reference = clazzService.getItemClassById(itemClass.getIdentifier());

        // parent wasn't changed, skip
        if(itemClass.getParent() == reference.getParent())
            return;

        if(reference.getChildren().size() > 0)
            errors.rejectValue("parent", "cmdb.item.class.validate.editable.haschildren");

        // sanitize parent value
        itemClass.setParent(reference.getParent());*/
    }
}
