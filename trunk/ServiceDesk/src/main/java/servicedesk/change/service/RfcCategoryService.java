/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import servicedesk.change.domain.RfcCategory;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcCategoryService extends CrudService<RfcCategory, Integer>, NamedService<RfcCategory, Integer> {

}
