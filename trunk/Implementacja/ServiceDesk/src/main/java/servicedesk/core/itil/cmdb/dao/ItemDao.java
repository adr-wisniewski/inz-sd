/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;
import servicedesk.infrastructure.interfaces.dao.Dao;

/**
 *
 * @author Adrian
 */
public interface ItemDao extends Dao<Item, Integer>{

    public void persist(UniversalItem object);
    public void merge(UniversalItem object);
    public void remove(UniversalItem object);

    public Iterable<Item> getByClass(ItemClass itemClass);
    public Iterable<Item> search(ItemCriteria criteria);
}
