/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.service;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.general.domain.HistoryRecord;

/**
 *
 * @author Adrian
 */
public interface HistoryService<Type extends DomainObject<Id>, Id extends Serializable> extends Service {
    public List<HistoryRecord<Type>> getChanges(Id id);
}
