/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain.helper;

import servicedesk.core.itil.cmdb.domain.EmployeeItem;
import servicedesk.core.itil.cmdb.domain.IncidentItem;
import servicedesk.core.itil.cmdb.domain.ProblemItem;
import servicedesk.core.itil.cmdb.domain.RfcItem;
import servicedesk.core.itil.cmdb.domain.ServiceItem;
import servicedesk.core.itil.cmdb.domain.UniversalItem;

/**
 *
 * @author Adrian
 */
public interface ItemVisitor {
    public void visit(UniversalItem universalItem);
    public void visit(ServiceItem serviceItem);
    public void visit(RfcItem rfcItem);
    public void visit(ProblemItem problemItem);
    public void visit(IncidentItem incidentItem);
    public void visit(EmployeeItem employeeItem);
}
