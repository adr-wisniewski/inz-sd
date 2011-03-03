/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import org.springframework.stereotype.Repository;
import sd.cmdb.domain.EntityClass;
import sd.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class EntityClassDaoImpl extends AbstractHibernateCrudDao<EntityClass, Integer> implements EntityClassDao {

}
