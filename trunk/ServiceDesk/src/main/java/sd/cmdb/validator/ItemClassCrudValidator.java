/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.validation.AbstractCrudValidator;

/**
 *
 * @author Adrian
 */
@Component
public class ItemClassCrudValidator extends AbstractCrudValidator<ItemClass> {

    @Autowired
    protected ItemClassValidator itemClassValidator;

    @Autowired
    protected ItemClassUpdateableValidator itemClassUpdateableValidator;

    @Autowired
    protected ItemClassDeleteableValidator itemClassDeleteableValidator;

    @Override
    protected void doValidateAdd(ItemClass object, BindingResult bindingResult) {
        itemClassValidator.validate(object, bindingResult);
    }

    @Override
    protected void doValidateUpdate(ItemClass object, BindingResult bindingResult) {
        itemClassUpdateableValidator.validate(object, bindingResult);
    }

    @Override
    protected void doValidateDelete(ItemClass object, BindingResult bindingResult) {
        itemClassDeleteableValidator.validate(object, bindingResult);
    }

}
