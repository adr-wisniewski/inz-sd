/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.dao.Dao;

/**
 *
 * @author Adrian
 */
public interface AdaptorItemClassDao extends Dao<ItemClass, Integer> {
    public ItemClass getByName(String name);
    public List<ItemClass> getAll();
}
