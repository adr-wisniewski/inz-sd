/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface CrudDao<Type extends DomainObject<Id>, Id extends Serializable> extends GetDao<Type, Id> {
    public void persist(Type object);
    public void remove(Type object);
    public Type merge(Type object);
}
