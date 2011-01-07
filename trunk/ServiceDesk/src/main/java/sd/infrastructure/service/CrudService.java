/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.service;

import java.io.Serializable;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface CrudService<Type extends DomainObject<Id>, Id extends Serializable> {
    public Type load(Id id);
    public Type get(Id id);

    public void add(Type object);
    public void update(Type object);
    public void delete(Type object);
}
