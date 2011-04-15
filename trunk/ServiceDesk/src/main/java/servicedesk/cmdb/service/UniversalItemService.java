/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import org.springframework.validation.BindingResult;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface UniversalItemService extends CrudService<UniversalItem, Integer> {

    public void preAdd(UniversalItem item, BindingResult bindingResult);

}
