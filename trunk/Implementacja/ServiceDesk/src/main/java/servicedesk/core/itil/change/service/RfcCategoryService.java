/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.interfaces.service.HierarchyService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcCategoryService
        extends CrudService<RfcCategory, Integer>,
        NamedService<RfcCategory, Integer>,
        HierarchyService<RfcCategory, Integer> {
}
