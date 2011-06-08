/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.SearchDao;

/**
 *
 * @author Adrian
 */
public interface RfcDao extends CrudDao<Rfc, Integer>, SearchDao<Rfc, Integer> {
    
}
