/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.util.Date;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.itil.cmdb.domain.RfcItem;
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
    
    public User getAuthor();
    public Date getTimestamp();
    
    
    
 
    public RfcCategory getCategory();
    public void setCategory(RfcCategory category);
    
    public RfcPriority getPriority();
    public void setPriority(RfcPriority priority);
   
    public RfcImpact getImpact();
    public void setImpact(RfcImpact impact);
    
    public RfcResolution getResolution();
    public void setResolution(RfcResolution resolution);
    
    public RfcState getState();
    public void setState(RfcState state);
    
    
    
    
    public Employee getManager();
    public void setManager(Employee employee);
    
    public Employee getBuilder();
    public void setBuilder(Employee employee);
    
    public RfcAuthority getAuthority();
    public void setAuthority(RfcAuthority authority);
    
    public RfcAuthority getCab();
    public void setCab(RfcAuthority cab);
    

    
    public String getPir();
    public void setPir(String pir);
    
    public String getComment();
    public void setComment(String comment);
    
    
    
    public RfcItem getRfcItem();
}
