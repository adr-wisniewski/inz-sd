/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import java.util.List;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.general.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface RfcDao extends CrudDao<Rfc, Integer> {

    public List<Rfc> search(RfcCriteria criteria);
    
}
