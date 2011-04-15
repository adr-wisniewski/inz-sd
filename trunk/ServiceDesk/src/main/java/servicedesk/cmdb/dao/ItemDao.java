/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.cmdb.domain.helper.ItemCriteria;

/**
 *
 * @author Adrian
 */
public interface ItemDao {
    
    public Item load(Integer id);
    public Item get(Integer id);
    public void persist(UniversalItem object);
    public void merge(UniversalItem object);
    public void remove(UniversalItem object);

    public Iterable<Item> getByClass(ItemClass itemClass);
    public Iterable<Item> search(ItemCriteria criteria);
}
