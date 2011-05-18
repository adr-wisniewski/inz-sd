/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import servicedesk.infrastructure.general.domain.NamedDomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface NamedDao<Type extends NamedDomainObject<Id>, Id extends Serializable> extends Dao {
    public Type getByName(String name);
    public Type loadByName(String name);
}
