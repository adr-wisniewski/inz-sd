/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.domain;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public interface CrudRepository<Type extends DomainObject<Id>, Id extends Serializable> extends Repository<Type, Id>   {
    public void persist(Type object);
    public void remove(Type object);
    public Type merge(Type object);
}
