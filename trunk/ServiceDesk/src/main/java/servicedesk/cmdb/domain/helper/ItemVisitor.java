/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain.helper;

import servicedesk.cmdb.domain.EmployeeItem;
import servicedesk.cmdb.domain.IncidentItem;
import servicedesk.cmdb.domain.ProblemItem;
import servicedesk.cmdb.domain.RfcItem;
import servicedesk.cmdb.domain.ServiceItem;
import servicedesk.cmdb.domain.UniversalItem;

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
