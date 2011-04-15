/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.List;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.infrastructure.dao.Dao;

/**
 *
 * @author Adrian
 */
public interface AdaptorItemClassDao extends Dao<ItemClass, Integer> {
    public ItemClass getByName(String name);
    public List<ItemClass> getAll();
}
