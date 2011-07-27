/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.itil.cmdb.domain.AbstractEntityClass;
import servicedesk.core.itil.cmdb.domain.EntityClass;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class EntityClassDaoImpl extends AbstractHibernateDao<EntityClass, AbstractEntityClass, Integer> implements EntityClassDao {

}
