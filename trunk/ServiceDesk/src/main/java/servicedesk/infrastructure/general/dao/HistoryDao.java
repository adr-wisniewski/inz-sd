/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.general.domain.HistoryRecord;

/**
 *
 * @author Adrian
 */
public interface HistoryDao {
    public <Type extends DomainObject<Id>, Id extends Serializable> 
            List<HistoryRecord<Type>> getChanges(Class<Type> type, Id id);
}
