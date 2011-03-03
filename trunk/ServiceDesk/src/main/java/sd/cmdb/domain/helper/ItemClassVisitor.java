/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain.helper;

import sd.cmdb.domain.EmployeeItemClass;
import sd.cmdb.domain.IncidentItemClass;
import sd.cmdb.domain.ProblemItemClass;
import sd.cmdb.domain.RfcItemClass;
import sd.cmdb.domain.ServiceItemClass;
import sd.cmdb.domain.UniversalItemClass;

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
