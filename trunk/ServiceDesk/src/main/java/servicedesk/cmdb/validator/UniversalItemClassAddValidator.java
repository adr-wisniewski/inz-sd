package servicedesk.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.service.ItemClassService;
import servicedesk.infrastructure.validation.AbstractValidator;

@Component
public class UniversalItemClassAddValidator extends AbstractValidator<UniversalItemClass> {

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected EntityClassAddValidator entityClassAddValidator;

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        entityClassAddValidator.doValidate(target, errors);
        checkUniqueName(target, errors);
    }

    protected void checkUniqueName(UniversalItemClass target, Errors errors) {
        ItemClass sameNameClass = itemClassService.getByName(target.getName());
        if(sameNameClass != null && !sameNameClass.getId().equals(target.getId()))
            errors.rejectValue("name", "validate.cmdb.item.class.name.notunique");
    }
}
