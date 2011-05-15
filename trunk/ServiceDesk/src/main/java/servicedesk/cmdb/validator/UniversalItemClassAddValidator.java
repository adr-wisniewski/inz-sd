package servicedesk.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.service.ItemClassService;
import servicedesk.infrastructure.general.validation.AbstractValidator;
import servicedesk.infrastructure.general.validation.ValidatorUtils;

@Component
public class UniversalItemClassAddValidator extends AbstractValidator<UniversalItemClass> {

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected EntityClassAddValidator entityClassAddValidator;

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        entityClassAddValidator.doValidate(target, errors);
        ValidatorUtils.rejectNotUniqueName(target, errors, itemClassService, "validate.cmdb.item.class.name.notunique");
    }
}
