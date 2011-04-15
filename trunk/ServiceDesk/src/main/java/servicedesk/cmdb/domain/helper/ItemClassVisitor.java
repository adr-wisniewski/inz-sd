/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain.helper;

import servicedesk.cmdb.domain.EmployeeItemClass;
import servicedesk.cmdb.domain.IncidentItemClass;
import servicedesk.cmdb.domain.ProblemItemClass;
import servicedesk.cmdb.domain.RfcItemClass;
import servicedesk.cmdb.domain.ServiceItemClass;
import servicedesk.cmdb.domain.UniversalItemClass;

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
