/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import org.springframework.stereotype.Repository;
import servicedesk.change.domain.RfcCategory;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcCategoryDaoImpl 
    extends AbstractHibernateDao<RfcCategory, Integer>
    implements RfcCategoryDao {

}
