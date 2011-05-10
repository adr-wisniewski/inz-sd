/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import java.util.List;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.general.service.CrudService;
import servicedesk.infrastructure.general.service.HistoryService;

/**
 *
 * @author Adrian
 */
public interface RfcService extends CrudService<Rfc, Integer>, HistoryService<Rfc, Integer> {
    public List<Rfc> search(RfcCriteria criteria);
}
