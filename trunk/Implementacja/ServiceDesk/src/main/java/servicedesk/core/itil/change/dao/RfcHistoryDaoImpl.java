/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcImpl;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateEnversHistoryDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcHistoryDaoImpl extends AbstractHibernateEnversHistoryDao<Rfc, RfcImpl, Integer> implements RfcHistoryDao {
    
}
