/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import servicedesk.change.domain.Rfc;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.SearchDao;

/**
 *
 * @author Adrian
 */
public interface RfcDao extends CrudDao<Rfc, Integer>, SearchDao<Rfc> {

}
