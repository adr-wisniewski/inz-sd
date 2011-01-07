/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Component
public class ItemClassDeleteableValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ItemClass.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ItemClass itemClass = (ItemClass)target;

        hasNoChildrenClasses(itemClass, errors);
        hasNoInstances(itemClass, errors);
        isNotUsedByRelationships(itemClass, errors);
    }

    protected void hasNoChildrenClasses(ItemClass itemClass, Errors errors)
    {
        if(itemClass.getChildren().size() > 0)
            errors.reject("cmdb.item.class.validate.deleteable[haschildren]");
    }

    protected void hasNoInstances(ItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("cmdb.item.class.validate.deleteable[hasinstances]");
    }

    protected void isNotUsedByRelationships(ItemClass itemClass, Errors errors)
    {
        //@TODO: finish this
        // errors.reject("cmdb.item.class.validate.deleteable[usedbyrelationship]", Object[] relationship.getName());
    }

}
