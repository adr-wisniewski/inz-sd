/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class UniversalDaoImpl extends AbstractHibernateCrudDao<UniversalItem, Integer> implements UniversalItemDao {

}
