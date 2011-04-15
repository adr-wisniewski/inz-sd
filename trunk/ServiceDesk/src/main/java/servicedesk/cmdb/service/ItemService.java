/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.helper.ItemCriteria;

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
