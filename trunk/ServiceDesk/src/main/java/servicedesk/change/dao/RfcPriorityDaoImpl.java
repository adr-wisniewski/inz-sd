/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

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
    
}
