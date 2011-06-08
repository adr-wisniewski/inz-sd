/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.service.RfcImpactService;
import servicedesk.core.base.validation.AbstractValidator;
import servicedesk.core.base.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcImpactValidator extends AbstractValidator<RfcImpact> {

    @Autowired
    protected RfcImpactService service;

    protected void checkProperties(RfcImpact target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.impact.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "order", "validate.change.rfc.impact.order.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, service, "validate.change.rfc.impact.name.notunique");
    }
}