/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcResolutionDaoImpl 
    extends AbstractHibernateDao<RfcResolution, Integer> 
    implements RfcResolutionDao {
    
    @Override
    @SuppressWarnings("unchecked")
    public List<RfcResolution> getAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(RfcResolution.class).addOrder(Order.asc("order")));
    }
}
