/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import servicedesk.change.domain.RfcPriority;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcPriorityDaoImpl  
    extends AbstractHibernateDao<RfcPriority, Integer> 
    implements RfcPriorityDao {
    
    @Override
    @SuppressWarnings("unchecked")
    public List<RfcPriority> getAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(RfcPriority.class).addOrder(Order.asc("order")));
    }
    
}
