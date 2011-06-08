/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.dao;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.infrastructure.search.SearchObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface SearchDao<Type extends DomainObject<Id>, Id extends Serializable> extends Dao<Type, Id> {
    List<Type> search(SearchObject<Type> query);
}
