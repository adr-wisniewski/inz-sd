/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcDaoImpl extends AbstractHibernateDao<Rfc, Integer> implements RfcDao {

}
