/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.util.Date;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.User;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface Rfc extends DomainObject<Integer> {
    public String getTitle();
    public void setTitle(String title);
    
    public String getDescription();
    public void setDescription(String description);
    
    public String getComment();
    public void setComment(String comment);
    
    public User getAuthor();
    public Date getTimestamp();
    public RfcState getState();
    public Employee getManager();
    
    public RfcPriority getPriority();
    public void setPriority(RfcPriority priority);
   
    public RfcImpact getImpact();
    public void setImpact(RfcImpact impact);
    
    public RfcCategory getCategory();
    public void setCategory(RfcCategory category);
    
    public RfcResolution getResolution();
    public void setResolution(RfcResolution resolution);

    public void setManager(Employee employee);
}
