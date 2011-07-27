/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.service;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface LoadService<Type extends DomainObject<Id>, Id extends Serializable> 
    extends Service {
    public List<Type> getAll();
    public Type load(Id id);
    public Type get(Id id);
    
}
