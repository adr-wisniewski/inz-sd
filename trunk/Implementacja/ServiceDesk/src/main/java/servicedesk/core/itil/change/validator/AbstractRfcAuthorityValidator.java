/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.service.RfcAuthorityService;
import servicedesk.infrastructure.validation.AbstractValidator;
import servicedesk.infrastructure.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcAuthorityValidator extends AbstractValidator<RfcAuthority> {
    @Autowired
    protected RfcAuthorityService authorityService;
    
    protected void checkProperties(RfcAuthority target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.authority.name.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, authorityService, "validate.change.rfc.category.authority.notunique");
    } 
}
