/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import java.util.List;
import servicedesk.core.itil.change.domain.Rfc;
import servicedesk.core.itil.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.interfaces.dao.CrudDao;

/**
 *
 * @author Adrian
 */
public interface RfcDao extends CrudDao<Rfc, Integer> {

    public List<Rfc> search(RfcCriteria criteria);
    
}
