/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.infrastructure.general.service.CrudService;

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
