/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import servicedesk.core.itil.change.domain.entity.RfcPriority;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcPriorityService extends CrudService<RfcPriority, Integer>, NamedService<RfcPriority, Integer> {
}
