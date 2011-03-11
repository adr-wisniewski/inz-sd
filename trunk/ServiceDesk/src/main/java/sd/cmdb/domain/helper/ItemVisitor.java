/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain.helper;

import sd.cmdb.domain.EmployeeItem;
import sd.cmdb.domain.IncidentItem;
import sd.cmdb.domain.ProblemItem;
import sd.cmdb.domain.RfcItem;
import sd.cmdb.domain.ServiceItem;
import sd.cmdb.domain.UniversalItem;

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
