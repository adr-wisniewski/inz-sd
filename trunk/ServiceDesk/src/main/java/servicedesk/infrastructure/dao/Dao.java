/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.dao;

import java.io.Serializable;
import servicedesk.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface Dao<Type extends DomainObject<Id>, Id extends Serializable> {
    public Type get(Id id);
}
