package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sd.cmdb.domain.ItemClass;

public class ItemClassValidator implements Validator {

    private ItemClass sameNameClass;

    public ItemClassValidator(ItemClass sameNameClass) {
        this.sameNameClass = sameNameClass;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ItemClass.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // simple properties
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "cmdb.item.class.validate.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "cmdb.item.class.validate.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "abstraction", "cmdb.item.class.validate.abstraction.empty");

        ItemClass original = (ItemClass)target;
        checkUniqueName(original, errors);
        checkParentChain(original, errors);
    }

    protected void checkUniqueName(ItemClass target, Errors errors) {
        if(sameNameClass != null && !sameNameClass.getIdentifier().equals(target.getIdentifier()))
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
