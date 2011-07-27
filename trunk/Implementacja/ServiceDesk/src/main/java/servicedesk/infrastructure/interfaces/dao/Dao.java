/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.interfaces.dao;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface Dao<Type extends DomainObject<Id>, Id extends Serializable> {
    public List<Type> getAll();
    public Type get(Id id);
    public Type load(Id id);
}
