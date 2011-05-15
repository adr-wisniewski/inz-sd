/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcImpactService extends CrudService<RfcImpact, Integer>, NamedService<RfcImpact, Integer> {
}
