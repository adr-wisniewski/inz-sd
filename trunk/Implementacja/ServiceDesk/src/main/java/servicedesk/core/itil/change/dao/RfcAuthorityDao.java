/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import java.util.List;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcAuthorityDao extends CrudDao<RfcAuthority, Integer>, NamedDao<RfcAuthority, Integer> {

    public boolean isMember(RfcAuthority authority, Employee employee);

    public List<RfcAuthority> getAllForRfc(Rfc rfc);

    public List<RfcAuthority> getAllCabsForRfc(Rfc rfc);
    
}
