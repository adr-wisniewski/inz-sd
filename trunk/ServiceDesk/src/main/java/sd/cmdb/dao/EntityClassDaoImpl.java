/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import org.springframework.stereotype.Repository;
import sd.cmdb.domain.AbstractEntityClass;
import sd.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class EntityClassDaoImpl extends AbstractHibernateCrudDao<AbstractEntityClass, Integer> implements EntityClassDao {

}
