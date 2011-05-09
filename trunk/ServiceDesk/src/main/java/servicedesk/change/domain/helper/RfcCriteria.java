/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain.helper;

import java.util.Date;
import org.springframework.util.StringUtils;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcState;
import servicedesk.domain.Employee;

/**
 *
 * @author Adrian
 */
public class RfcCriteria {
    private Integer id;
    private RfcState state;
    private Employee creator;
    private Date creationTimestampMin;
    private Date creationTimestampMax;
    private String title;
    private String description;
    private Employee manager;
    private RfcPriority priority;
    private RfcImpact impact;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the state
     */
    public RfcState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(RfcState state) {
        this.state = state;
    }

    /**
     * @return the creator
     */
    public Employee getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    /**
     * @return the creationTimestampMin
     */
    public Date getCreationTimestampMin() {
        return creationTimestampMin;
    }

    /**
     * @param creationTimestampMin the creationTimestampMin to set
     */
    public void setCreationTimestampMin(Date creationTimestampMin) {
        this.creationTimestampMin = creationTimestampMin;
    }

    /**
     * @return the creationTimestampMax
     */
    public Date getCreationTimestampMax() {
        return creationTimestampMax;
    }

    /**
     * @param creationTimestampMax the creationTimestampMax to set
     */
    public void setCreationTimestampMax(Date creationTimestampMax) {
        this.creationTimestampMax = creationTimestampMax;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the manager
     */
    public Employee getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * @return the priority
     */
    public RfcPriority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(RfcPriority priority) {
        this.priority = priority;
    }

    /**
     * @return the impact
     */
    public RfcImpact getImpact() {
        return impact;
    }

    /**
     * @param impact the impact to set
     */
    public void setImpact(RfcImpact impact) {
        this.impact = impact;
    }
    
    public boolean isInitialized()
    {
        return
            id != null
            || state != null
            || creator != null
            || creationTimestampMin != null
            || creationTimestampMax != null
            || StringUtils.hasText(title)
            || StringUtils.hasText(description)
            || priority != null
            || impact != null;     
    }
}