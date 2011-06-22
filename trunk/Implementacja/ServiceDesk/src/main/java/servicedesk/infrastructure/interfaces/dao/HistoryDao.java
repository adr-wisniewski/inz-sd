/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.dao;

import java.io.Serializable;
import java.util.List;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.core.base.history.domain.HistoryRecord;

/**
 *
 * @author Adrian
 */
public interface HistoryDao {
    public <Type extends DomainObject<Id>, Id extends Serializable> 
            List<HistoryRecord<Type>> getChanges(Class<Type> type, Id id);
}
