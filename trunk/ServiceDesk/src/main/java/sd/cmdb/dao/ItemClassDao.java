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
public interface ItemClassDao extends Dao<ItemClass, Integer> {
    public ItemClass load(Integer id);
    public List<ItemClass> getAll();

    public ItemClass getByName(String name);
    public ItemClass loadByName(String name);
}
