/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.cmdb.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.validation.AbstractValidator;
import servicedesk.infrastructure.validation.Validated;
import servicedesk.web.itil.cmdb.helper.UniversalItemClassPickForm;

/**
 *
 * @author Adrian
 */
@Service
public class UniversalItemClassPickFormService {
    @Validated(name="itemClass", validator=UniversalItemClassPickFormService.Validator.class)
    public UniversalItem pick(UniversalItemClassPickForm form, BindingResult bindingResult) {
        return form.getItemClass().createItem();
    }
    
    @Component
    protected static class Validator extends AbstractValidator<UniversalItemClassPickForm> {

        @Override
        protected void doValidate(UniversalItemClassPickForm target, Errors errors) {
            attachDao.attach(target.getItemClass());
            if(target.getItemClass() == null)
                errors.rejectValue("itemClass", "validate.cmdb.item.itemClass.empty");
            else if(target.getItemClass().isAbstraction())
                errors.rejectValue("itemClass", "validate.cmdb.item.itemClass.abstract");
        }
    }   
}
