/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface Repository<Type extends DomainObject<Id>, Id extends Serializable> {
    public List<Type> getAll();
    public Type get(Id id);
    public Type load(Id id);
}
