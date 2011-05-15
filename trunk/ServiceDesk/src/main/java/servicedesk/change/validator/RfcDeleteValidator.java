/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.change.domain.Rfc;

/**
 *
 * @author Adrian
 */
@Component
public class RfcDeleteValidator extends AbstractRfcValidator {

    @Override
    protected void doValidate(Rfc target, Errors errors) {
        // TODO: any conditions?
    }
    
}
