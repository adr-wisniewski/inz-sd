/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.RfcImpact;

/**
 *
 * @author Adrian
 */
@Component
public class RfcImpactAddValidator extends AbstractRfcImpactValidator {
    @Override
    protected void doValidate(RfcImpact target, Errors errors) {
        checkProperties(target, errors);
    }
}
