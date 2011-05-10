/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.change.domain.Rfc;
import servicedesk.infrastructure.general.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RfcAddValidator extends AbstractValidator<Rfc> {

    @Override
    protected void doValidate(Rfc target, Errors errors) {
        checkSimple(target, errors);
    }
    
    protected void checkSimple(Rfc target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "validate.change.rfc.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.change.rfc.description.empty");
    }
    
}
