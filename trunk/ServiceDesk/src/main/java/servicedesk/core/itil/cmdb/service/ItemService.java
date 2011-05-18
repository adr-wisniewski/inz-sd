/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;

/**
 *
 * @author Adrian
 */
public interface ItemService {
    public Item load(Integer id);
    public Item get(Integer id);
    public Iterable<Item> getByClass(ItemClass itemClass);
    public Iterable<Item> search(ItemCriteria criteria);
}
