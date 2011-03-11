/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import org.springframework.validation.BindingResult;
import sd.cmdb.domain.UniversalItem;
import sd.infrastructure.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface UniversalItemService extends CrudService<UniversalItem, Integer> {

    public void preAdd(UniversalItem item, BindingResult bindingResult);

}
