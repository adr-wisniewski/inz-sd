/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.entity.RfcCategory;

/**
 *
 * @author Adrian
 */
@Component
public class RfcCategoryEditValidator extends AbstractRfcCategoryValidator {
    @Override
    protected void doValidate(RfcCategory target, Errors errors) {
        checkProperties(target, errors);
    }
}
