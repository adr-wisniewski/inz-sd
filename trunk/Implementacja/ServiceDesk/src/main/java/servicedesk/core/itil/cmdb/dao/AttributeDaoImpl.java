/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.itil.cmdb.domain.Attribute;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class AttributeDaoImpl extends AbstractHibernateDao<Attribute, Attribute, Integer> implements AttributeDao {

}


//TODO: double submit problem
//TODO: error pages
//TODO: prg form expired view
//TODO: holding data in session for all forms?