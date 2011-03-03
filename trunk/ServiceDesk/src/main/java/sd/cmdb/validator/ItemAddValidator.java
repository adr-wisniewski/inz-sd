/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.validation.Errors;
import sd.cmdb.domain.Item;
import sd.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
public class ItemAddValidator extends AbstractValidator<Item> {

    @Override
    protected void doValidate(Item target, Errors errors) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
