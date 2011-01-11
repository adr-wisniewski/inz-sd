package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.service.ItemClassService;
import sd.infrastructure.validation.AbstractValidator;

@Component
public class ItemClassValidator extends AbstractValidator<ItemClass> {

    @Autowired
    protected ItemClassService itemClassService;

    @Override
    public void doValidate(ItemClass target, Errors errors) {
        checkSimple(target, errors);
        checkUniqueName(target, errors);
        checkParentChain(target, errors);
    }

    protected void checkSimple(ItemClass target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "cmdb.item.class.validate.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "cmdb.item.class.validate.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "cmdb.item.class.validate.abstraction.empty");
    }

    protected void checkUniqueName(ItemClass target, Errors errors) {
        ItemClass sameNameClass = itemClassService.getByName(target.getName());

        if(sameNameClass != null && !sameNameClass.getId().equals(target.getId()))
            errors.rejectValue("name", "cmdb.item.class.validate.name.notunique");
    }

    protected void checkParentChain(ItemClass target, Errors errors)
    {
        // cannot be parent to itself
        ItemClass parent = target.getParent();

        while(parent != null) {
            if(target.equals(parent)) {
                errors.rejectValue("parent", "cmdb.item.class.validate.parent.recursive");
                break;
            }

            parent = parent.getParent();
        }
    }
}
