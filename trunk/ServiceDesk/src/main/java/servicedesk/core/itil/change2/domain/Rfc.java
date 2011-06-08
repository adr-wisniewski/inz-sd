/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change2.domain;

import java.util.Date;
import servicedesk.core.hr.domain.Employee;
import servicedesk.core.itil.change.domain.RfcCategory;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.itil.change.domain.RfcState;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface Rfc extends DomainObject<Integer> {
    public String getTitle();
    public String getDescription();
    public RfcPriority getPriority();
    public RfcImpact getImpact();
    public RfcCategory getCategory();
    public Employee getCreator();
    public Date getTimestamp();
    public RfcState getState();
    public Employee getManager();
    public RfcResolution getResolution();
    
    public void assignTo(ChangeManager manager);
    
}
