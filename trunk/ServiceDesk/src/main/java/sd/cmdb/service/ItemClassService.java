/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

/**
 *
 * @author Adrian
 */
public interface ItemClassService {
    public void add(ItemClass itemClass);
    public void update(ItemClass itemClass);
    public void delete(ItemClass classId);

    public ItemClass load(Integer classId);
    public ItemClass getByName(String name);
    public ItemClass getById(Integer identifier);
    public List<ItemClass> getAll();
    public List<ItemClass> search(ItemClassCriteria criteria);
}
