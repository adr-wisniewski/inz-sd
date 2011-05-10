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
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcPriorityDaoImpl  
    extends AbstractHibernateCrudDao<RfcPriority, Integer> 
    implements RfcPriorityDao {
    
    @Override
    public List<RfcPriority> getAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(RfcPriority.class).addOrder(Order.asc("viewOrder")));
    }
    
}
