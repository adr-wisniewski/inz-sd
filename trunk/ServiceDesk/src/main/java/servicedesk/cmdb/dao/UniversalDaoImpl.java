/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UniversalDaoImpl extends AbstractHibernateDao<UniversalItem, Integer> implements UniversalItemDao {

}
