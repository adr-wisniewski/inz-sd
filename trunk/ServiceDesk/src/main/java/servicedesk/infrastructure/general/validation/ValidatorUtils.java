/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.validation;

import java.io.Serializable;
import org.springframework.validation.Errors;
import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;
import servicedesk.infrastructure.general.domain.NamedDomainObject;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public final class ValidatorUtils {
    
    private ValidatorUtils() {
        
    }
    
    static public <Type extends NamedDomainObject<Id>, Id extends Serializable> 
    void rejectNotUniqueName(Type target, Errors errors, NamedService<Type,Id> service, String error) {
        if(target.getName() != null && !errors.hasFieldErrors("name") ) {
            Type sameName = service.getByName(target.getName());
            if(sameName != null && !sameName.getId().equals(target.getId()))
            errors.rejectValue("name", error);
        }
    }
    
   static public void rejectParentRecursive(HierarchicalDomainObject<? extends Serializable> target, Errors errors, String error) {
       
       if(!errors.hasFieldErrors("parent")) {
            // cannot be parent to itself
            HierarchicalDomainObject<?> parent = target.getParent();

            while(parent != null) {
                if(target.equals(parent)) {
                    errors.rejectValue("parent", error);
                    break;
                }

                parent = parent.getParent();
            }
       }
   }
   
   static public void rejectHasChildren(HierarchicalDomainObject<? extends Serializable> target, Errors errors, String error) {
        if(target.getChildren().size() > 0)
            errors.reject(error);
   }
}
