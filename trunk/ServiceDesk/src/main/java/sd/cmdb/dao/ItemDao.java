/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.UniversalItem;

/**
 *
 * @author Adrian
 */
public interface ItemDao {
    public List<Item> getByClass(ItemClass itemClass);

    public Item load(Integer id);
    public Item get(Integer id);
    public void persist(UniversalItem object);
    public void merge(UniversalItem object);
    public void remove(UniversalItem object);
}
