/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.AbstractEntityClass;
import servicedesk.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class EntityClassDaoImpl extends AbstractHibernateCrudDao<AbstractEntityClass, Integer> implements EntityClassDao {

}
