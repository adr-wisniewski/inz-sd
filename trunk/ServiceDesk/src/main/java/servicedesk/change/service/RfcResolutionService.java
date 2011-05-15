/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import servicedesk.change.domain.RfcResolution;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcResolutionService extends CrudService<RfcResolution, Integer>, NamedService<RfcResolution, Integer> {
}
