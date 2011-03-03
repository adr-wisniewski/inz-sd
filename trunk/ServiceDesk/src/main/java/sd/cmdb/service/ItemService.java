/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface ItemService extends CrudService<Item, Integer> {
    public List<Item> getByClass(ItemClass itemClass);
}
