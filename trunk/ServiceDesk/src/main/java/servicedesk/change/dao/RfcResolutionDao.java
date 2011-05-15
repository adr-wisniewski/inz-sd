/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import servicedesk.change.domain.RfcResolution;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcResolutionDao extends CrudDao<RfcResolution, Integer>, NamedDao<RfcResolution, Integer> {  
}
