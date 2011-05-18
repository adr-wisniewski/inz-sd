/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.RfcPriority;

/**
 *
 * @author Adrian
 */
@Component
public class RfcPriorityAddValidator extends AbstractRfcPriorityValidator {
    @Override
    protected void doValidate(RfcPriority target, Errors errors) {
        checkProperties(target, errors);
    }
}
