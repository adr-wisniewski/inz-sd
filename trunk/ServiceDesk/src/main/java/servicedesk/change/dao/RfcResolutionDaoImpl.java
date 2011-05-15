/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import servicedesk.change.domain.RfcResolution;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

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
