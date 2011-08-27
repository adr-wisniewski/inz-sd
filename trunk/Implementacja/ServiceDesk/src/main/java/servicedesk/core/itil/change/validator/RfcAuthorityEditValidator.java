/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;

/**
 *
 * @author Adrian
 */
@Component
public class RfcAuthorityEditValidator extends AbstractRfcAuthorityValidator {
    @Override
    protected void doValidate(RfcAuthority target, Errors errors) {
        checkProperties(target, errors);
    }
}