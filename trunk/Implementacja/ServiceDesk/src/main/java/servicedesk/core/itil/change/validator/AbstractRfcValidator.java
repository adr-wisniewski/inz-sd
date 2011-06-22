/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.core.base.validation.AbstractValidator;

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
