/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.interfaces.service;

import java.io.Serializable;
import org.springframework.validation.BindingResult;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface EditService<Type extends DomainObject<Id>, Id extends Serializable> extends LoadService<Type, Id> {
    public void add(Type object, BindingResult bindingResult);
    public void update(Type object, BindingResult bindingResult);
    public void delete(Type object);
}
