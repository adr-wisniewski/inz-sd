/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.infrastructure.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
@Component
public class RfcCategoryDeleteValidator extends AbstractRfcCategoryValidator {

    @Override
    protected void doValidate(RfcCategory target, Errors errors) {
        ValidatorUtils.rejectHasChildren(target, errors, "validate.change.rfc.category.delete.haschildren");
    }
    
}
