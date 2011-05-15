/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.change.domain.RfcImpact;

/**
 *
 * @author Adrian
 */
@Component
public class RfcImpactDeleteValidator extends AbstractRfcImpactValidator {
    @Override
    protected void doValidate(RfcImpact target, Errors errors) {
        // TODO: any condition?
    }
}
