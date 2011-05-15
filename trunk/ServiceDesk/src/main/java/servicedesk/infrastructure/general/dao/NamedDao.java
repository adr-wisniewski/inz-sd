/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import servicedesk.infrastructure.general.domain.NamedDomainObject;

/**
 *
 * @author Adrian
 */
public interface NamedDao<Type extends NamedDomainObject<Id>, Id extends Serializable> extends Dao<Type, Id> {
    public Type getByName(String name);
    public Type loadByName(String name);
}
