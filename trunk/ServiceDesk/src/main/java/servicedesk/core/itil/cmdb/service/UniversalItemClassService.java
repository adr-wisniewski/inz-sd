/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import java.util.List;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.infrastructure.interfaces.service.CrudService;

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
