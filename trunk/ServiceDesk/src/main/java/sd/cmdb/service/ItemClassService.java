/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.UniversalItemClass;

/**
 *
 * @author Adrian
 */
public interface ItemClassService {

    public List<ItemClass> getAll();

    public ItemClass load(Integer id);

    public ItemClass loadByName(String classname);

    public ItemClass getByName(String name);

}
