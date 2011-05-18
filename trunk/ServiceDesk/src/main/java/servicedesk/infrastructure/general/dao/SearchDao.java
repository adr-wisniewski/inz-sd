/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.util.List;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.search.domain.Query;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public interface SearchDao<Type extends DomainObject<?>> extends Dao {
    public List<Type> search(Query<Type> query);
}
