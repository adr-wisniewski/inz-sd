package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.service.ItemClassService;
import sd.infrastructure.validation.AbstractValidator;

@Component
public class UniversalItemClassAddValidator extends AbstractValidator<UniversalItemClass> {

    @Autowired
    protected ItemClassService itemClassService;

    @Override
    protected void doValidate(UniversalItemClass target, Errors errors) {
        checkSimple(target, errors);
        checkUniqueName(target, errors);
        checkParentChain(target, errors);
    }

    protected void checkSimple(UniversalItemClass target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.cmdb.item.class.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "validate.cmdb.item.class.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "validate.cmdb.item.class.abstraction.empty");
    }

    protected void checkUniqueName(UniversalItemClass target, Errors errors) {
        ItemClass sameNameClass = itemClassService.getByName(target.getName());

        if(sameNameClass != null && !sameNameClass.getId().equals(target.getId()))
            errors.rejectValue("name", "validate.cmdb.item.class.name.notunique");
    }

    protected void checkParentChain(UniversalItemClass target, Errors errors)
    {
        // cannot be parent to itself
        UniversalItemClass parent = target.getParent();

        while(parent != null) {
            if(target.equals(parent)) {
                errors.rejectValue("parent", "validate.cmdb.item.class.parent.recursive");
                break;
            }

            parent = parent.getParent();
        }
    }
}
