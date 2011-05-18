/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UniversalDaoImpl extends AbstractHibernateDao<UniversalItem, Integer> implements UniversalItemDao {

}
