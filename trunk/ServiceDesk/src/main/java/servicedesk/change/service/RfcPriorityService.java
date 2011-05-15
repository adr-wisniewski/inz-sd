/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import servicedesk.change.domain.RfcPriority;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcPriorityService extends CrudService<RfcPriority, Integer>, NamedService<RfcPriority, Integer> {
}
