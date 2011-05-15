/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.change.domain.RfcResolution;
import servicedesk.change.service.RfcResolutionService;
import servicedesk.infrastructure.general.validation.AbstractValidator;
import servicedesk.infrastructure.general.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcResolutionValidator extends AbstractValidator<RfcResolution> {

    @Autowired
    protected RfcResolutionService service;

    protected void checkProperties(RfcResolution target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.impact.name.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, service, "validate.change.rfc.impact.name.notunique");
    }
}
