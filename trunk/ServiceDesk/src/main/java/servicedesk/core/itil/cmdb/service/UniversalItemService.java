/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import org.springframework.validation.BindingResult;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.interfaces.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface UniversalItemService extends CrudService<UniversalItem, Integer> {

    public void preAdd(UniversalItem item, BindingResult bindingResult);

}
