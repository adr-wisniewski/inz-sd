/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.infrastructure.interfaces.dao.HistoryDao;

/**
 *
 * @author Adrian
 */
public interface RfcHistoryDao extends HistoryDao<Rfc, Integer> {
    
}