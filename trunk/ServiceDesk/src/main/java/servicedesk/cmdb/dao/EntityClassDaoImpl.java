/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.AbstractEntityClass;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class EntityClassDaoImpl extends AbstractHibernateDao<AbstractEntityClass, Integer> implements EntityClassDao {

}
