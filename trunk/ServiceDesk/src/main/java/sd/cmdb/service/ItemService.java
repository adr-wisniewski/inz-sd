/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
public interface ItemService {
    public List<Item> getByClass(ItemClass itemClass);
    public Item load(Integer id);
    public Item get(Integer id);
}
