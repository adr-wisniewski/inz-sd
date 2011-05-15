/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.change.domain.Rfc;
import servicedesk.infrastructure.general.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcValidator extends AbstractValidator<Rfc> {

    protected void checkProperties(Rfc target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "validate.change.rfc.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.change.rfc.description.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "validate.change.rfc.state.empty");
    }
    
}
