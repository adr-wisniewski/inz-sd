/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import org.springframework.stereotype.Repository;
import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcImpactDaoImpl 
    extends AbstractHibernateCrudDao<RfcImpact, Integer> 
    implements RfcImpactDao {
    
}
