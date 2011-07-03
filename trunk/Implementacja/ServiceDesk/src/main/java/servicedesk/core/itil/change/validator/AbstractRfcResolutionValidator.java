/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.entity.RfcResolution;
import servicedesk.core.itil.change.service.RfcResolutionService;
import servicedesk.infrastructure.validation.AbstractValidator;
import servicedesk.infrastructure.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcResolutionValidator extends AbstractValidator<RfcResolution> {

    @Autowired
    protected RfcResolutionService service;

    protected void checkProperties(RfcResolution target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.resolution.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "order", "validate.change.rfc.resolution.order.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, service, "validate.change.rfc.resolution.name.notunique");
    }
}
