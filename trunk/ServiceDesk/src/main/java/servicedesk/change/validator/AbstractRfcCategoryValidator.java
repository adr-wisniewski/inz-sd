/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.change.domain.RfcCategory;
import servicedesk.change.service.RfcCategoryService;
import servicedesk.infrastructure.general.validation.AbstractValidator;
import servicedesk.infrastructure.general.validation.ValidatorUtils;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcCategoryValidator extends AbstractValidator<RfcCategory> {
   
    @Autowired
    protected RfcCategoryService categoryService;
    
    protected void checkProperties(RfcCategory target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.change.rfc.category.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "validate.change.rfc.category.abstraction.empty");
        ValidatorUtils.rejectNotUniqueName(target, errors, categoryService, "validate.change.rfc.category.name.notunique");
        ValidatorUtils.rejectParentRecursive(target, errors, "validate.change.rfc.category.parent.recursive");
    } 
}
