/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain.helper;

import servicedesk.core.itil.cmdb.domain.EmployeeItemClass;
import servicedesk.core.itil.cmdb.domain.IncidentItemClass;
import servicedesk.core.itil.cmdb.domain.ProblemItemClass;
import servicedesk.core.itil.cmdb.domain.RfcItemClass;
import servicedesk.core.itil.cmdb.domain.ServiceItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;

/**
 *
 * @author Adrian
 */
public interface ItemClassVisitor {

    public void visit(UniversalItemClass universalItemClass);
    public void visit(EmployeeItemClass employeeItemClass);
    public void visit(IncidentItemClass incidentItemClass);
    public void visit(ProblemItemClass problemItemClass);
    public void visit(RfcItemClass rfcItemClass);
    public void visit(ServiceItemClass serviceItemClass);

}
