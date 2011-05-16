/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.service.RfcPriorityService;
import servicedesk.infrastructure.general.validation.AbstractValidator;
import servicedesk.infrastructure.general.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcPriorityValidator extends AbstractValidator<RfcPriority> {
    @Autowired
    protected RfcPriorityService service;

    protected void checkProperties(RfcPriority target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.priority.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "order", "validate.change.rfc.priority.order.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, service, "validate.change.rfc.priority.name.notunique");
    } 
}
