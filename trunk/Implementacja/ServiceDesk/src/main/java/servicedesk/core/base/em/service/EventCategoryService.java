/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.em.service;

import servicedesk.core.base.em.domain.EventCategory;
import servicedesk.infrastructure.interfaces.service.HierarchyService;

/**
 *
 * @author Adrian
 */
public interface EventCategoryService extends HierarchyService<EventCategory, String> {
    
}
