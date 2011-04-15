/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import servicedesk.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
public interface ItemClassService {
    public List<ItemClass> getAll();

    public ItemClass load(Integer id);
    public ItemClass get(Integer id);
    
    public ItemClass loadByName(String classname);
    public ItemClass getByName(String name);
}
