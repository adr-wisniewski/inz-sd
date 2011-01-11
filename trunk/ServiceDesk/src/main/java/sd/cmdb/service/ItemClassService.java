/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface ItemClassService extends CrudService<ItemClass, Integer> {
    public List<ItemClass> search(ItemClassCriteria criteria);
    public List<ItemClass> getAll();
    public ItemClass getByName(String name);
}
