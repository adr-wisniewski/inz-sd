/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.service;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface GetService<Type extends DomainObject<Id>, Id extends Serializable> 
    extends Service {
    public List<Type> getAll();
    public Type load(Integer id);
    public Type get(Integer id);
    
}
