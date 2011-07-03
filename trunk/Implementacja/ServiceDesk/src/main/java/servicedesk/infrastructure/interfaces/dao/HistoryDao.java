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
public interface HistoryDao<Type extends DomainObject<Id>, Id extends Serializable> {
    public List<HistoryRecord<Type>> getChanges(Id id);
}
