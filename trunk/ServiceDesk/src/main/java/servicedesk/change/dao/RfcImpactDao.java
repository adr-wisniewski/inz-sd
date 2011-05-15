/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import servicedesk.change.domain.RfcImpact;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcImpactDao extends CrudDao<RfcImpact, Integer>, NamedDao<RfcImpact, Integer> {  
}
