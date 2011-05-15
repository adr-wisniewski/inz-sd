/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.validation.Errors;
import servicedesk.change.domain.RfcCategory;

/**
 *
 * @author Adrian
 */
public class RfcCategoryEditValidator extends AbstractRfcCategoryValidator {
    @Override
    protected void doValidate(RfcCategory target, Errors errors) {
        checkProperties(target, errors);
    }
}
