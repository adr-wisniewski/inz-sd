/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.List;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.infrastructure.interfaces.service.CrudService;
import servicedesk.infrastructure.interfaces.service.NamedService;

/**
 *
 * @author Adrian
 */
public interface RfcAuthorityService extends CrudService<RfcAuthority, Integer>, NamedService<RfcAuthority, Integer> {
    public boolean isMember(RfcAuthority authority, Employee employee);

    public List<RfcAuthority> getAllForRfc(Rfc rfc);

    public List<RfcAuthority> getAllCabsForRfc(Rfc rfc);
}
