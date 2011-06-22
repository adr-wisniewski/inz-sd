/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcImpactService extends CrudService<RfcImpact, Integer>, NamedService<RfcImpact, Integer> {
}
