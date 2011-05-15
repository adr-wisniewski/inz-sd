/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.change.domain.RfcCategory;

/**
 *
 * @author Adrian
 */
@Component
public class RfcCategoryAddValidator extends AbstractRfcCategoryValidator {
    @Override
    protected void doValidate(RfcCategory target, Errors errors) {
        checkProperties(target, errors);
    }
}