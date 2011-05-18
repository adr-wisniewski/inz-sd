/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface GetDao<Type extends DomainObject<Id>, Id extends Serializable> extends Dao {
    public List<Type> getAll();
    public Type get(Id id);
    public Type load(Id id);
}
