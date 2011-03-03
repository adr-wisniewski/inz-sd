/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface UniversalItemClassService extends CrudService<UniversalItemClass, Integer> {
    public List<UniversalItemClass> search(ItemClassCriteria criteria);
    public List<UniversalItemClass> getAll();
    public UniversalItemClass getByName(String name);
    public UniversalItemClass loadByName(String name);
}
