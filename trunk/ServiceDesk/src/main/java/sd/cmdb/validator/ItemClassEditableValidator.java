/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
public class ItemClassEditableValidator extends ItemClassValidator {

    public ItemClassEditableValidator(ItemClass sameNameClass) {
        super(sameNameClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        super.validate(target, errors);

        ItemClass itemClass = (ItemClass)target;
        checkParentChanged(itemClass, errors);
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
