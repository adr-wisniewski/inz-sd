/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.RfcResolution;

/**
 *
 * @author Adrian
 */
@Component
public class RfcResolutionAddValidator extends AbstractRfcResolutionValidator {
    @Override
    protected void doValidate(RfcResolution target, Errors errors) {
        checkProperties(target, errors);
    }
}
