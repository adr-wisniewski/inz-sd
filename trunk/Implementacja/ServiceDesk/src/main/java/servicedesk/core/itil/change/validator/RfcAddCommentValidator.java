/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RfcAddCommentValidator extends AbstractValidator<Rfc> {

    @Override
    protected void doValidate(Rfc target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "validate.change.rfc.comment.empty");
    }
    
}
