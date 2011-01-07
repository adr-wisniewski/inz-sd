/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.dao;

import java.io.Serializable;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface Dao<Type extends DomainObject<Id>, Id extends Serializable> {
    public Class<Type> getTypeClass();
    public Class<Id> getIdClass();
}
