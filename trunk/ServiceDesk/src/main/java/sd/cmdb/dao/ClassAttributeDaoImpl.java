/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import org.springframework.stereotype.Repository;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributeId;
import sd.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class ClassAttributeDaoImpl extends AbstractHibernateCrudDao<ClassAttribute, ClassAttributeId> {

}


//TODO: double submit problem
//TODO: error pages
//TODO: prg form expired view
//TODO: holding data in session for all forms?