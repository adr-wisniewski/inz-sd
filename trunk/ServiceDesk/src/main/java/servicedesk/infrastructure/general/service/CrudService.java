/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.service;

import java.io.Serializable;
import org.springframework.validation.BindingResult;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface CrudService<Type extends DomainObject<Id>, Id extends Serializable> extends GetService<Type, Id> {
    public void add(Type object, BindingResult bindingResult);
    public void update(Type object, BindingResult bindingResult);
    public void delete(Type object);
}
