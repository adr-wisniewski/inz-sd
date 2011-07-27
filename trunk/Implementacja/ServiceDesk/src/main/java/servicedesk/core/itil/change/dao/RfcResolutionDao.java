/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import servicedesk.core.itil.change.domain.entity.RfcResolution;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcResolutionDao extends CrudDao<RfcResolution, Integer>, NamedDao<RfcResolution, Integer> {  
}
