/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.entity.RfcPriority;
import servicedesk.core.itil.change.service.RfcPriorityService;
import servicedesk.infrastructure.validation.AbstractValidator;
import servicedesk.infrastructure.validation.ValidatorUtils;

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
