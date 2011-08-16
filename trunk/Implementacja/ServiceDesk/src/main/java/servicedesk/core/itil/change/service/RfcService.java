/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.List;
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcChange;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.search.SearchObject;

/**
 *
 * @author Adrian
 */
public interface RfcService extends CrudService<Rfc, Integer> {
    public List<Rfc> search(SearchObject<Rfc> criteria);
    public List<RfcChange> getChanges(Rfc rfc);

    public void updateFlow(Rfc rfc, BindingResult bindingResult);
    public void assignToSelfFlow(Rfc rfc, BindingResult bindingResult);
    public void assignFlow(Rfc rfc, BindingResult bindingResult);
    public void reviewFlow(Rfc rfc, BindingResult bindingResult);
    public void assessFlow(Rfc rfc, BindingResult bindingResult);
    public void authorizeFlow(Rfc rfc, BindingResult bindingResult);
    public void scheduleFlow(Rfc rfc, BindingResult bindingResult);
    public void buildFlow(Rfc rfc, BindingResult bindingResult);
    public void closeFlow(Rfc rfc, BindingResult bindingResult);
    public void rejectFlow(Rfc rfc, BindingResult bindingResult);
    public void appealFlow(Rfc rfc, BindingResult bindingResult);
    public void addCommentFlow(Rfc rfc, BindingResult bindingResult);
    public void acceptAppeal(Rfc rfc, BindingResult bindingResult);
}
