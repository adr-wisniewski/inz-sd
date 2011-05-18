/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.List;
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.core.itil.change.domain.RfcChange;
import servicedesk.core.itil.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.interfaces.service.CrudService;

/**
 *
 * @author Adrian
 */
public interface RfcService extends CrudService<Rfc, Integer> {
    public List<Rfc> search(RfcCriteria criteria);
    public List<RfcChange> getChanges(Rfc rfc);

    public void addComment(Rfc rfc, BindingResult bindingResult);
    public void assignToSelf(Rfc rfc, BindingResult bindingResult);
}
