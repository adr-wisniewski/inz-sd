/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface Dao<Type extends DomainObject<Id>, Id extends Serializable> {
    public Type get(Id id);
    public Type load(Id id);
}
