/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import org.springframework.stereotype.Repository;
import servicedesk.change.domain.Rfc;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcDaoImpl extends AbstractHibernateDao<Rfc, Integer> implements RfcDao {

}
