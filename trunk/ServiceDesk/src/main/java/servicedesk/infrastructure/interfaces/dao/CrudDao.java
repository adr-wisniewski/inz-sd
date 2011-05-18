/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.interfaces.dao;

import java.io.Serializable;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface CrudDao<Type extends DomainObject<Id>, Id extends Serializable> extends Dao<Type, Id> {
    public void persist(Type object);
    public void remove(Type object);
    public Type merge(Type object);
}
