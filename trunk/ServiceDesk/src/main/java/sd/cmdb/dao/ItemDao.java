/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface ItemDao extends CrudDao<Item, Integer> {
    public List<Item> getByClass(ItemClass itemClass);
}
