/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.change.domain.RfcCategory;
import servicedesk.infrastructure.general.validation.ValidatorUtils;

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
