/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcImpactDaoImpl 
    extends AbstractHibernateDao<RfcImpact, Integer> 
    implements RfcImpactDao {
    
    @Override
    @SuppressWarnings("unchecked")
    public List<RfcImpact> getAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(RfcImpact.class).addOrder(Order.asc("order")));
    }
}
