/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.im.service;

import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.infrastructure.interfaces.service.HierarchyService;

/**
 *
 * @author Adrian
 */
public interface IncidentCategoryService extends HierarchyService<IncidentCategory, String> {
    
}
