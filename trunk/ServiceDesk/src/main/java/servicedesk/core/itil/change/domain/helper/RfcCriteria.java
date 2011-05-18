/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.helper;

import java.util.Date;
import org.springframework.util.StringUtils;
import servicedesk.core.itil.change.domain.RfcCategory;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.domain.RfcResolution;
import servicedesk.core.itil.change.domain.RfcState;
import servicedesk.core.hr.domain.Employee;

/**
 *
 * @author Adrian
 */
public class RfcCriteria {
    private Integer id;
    private Employee creator;
    private Date timestampMin;
    private Date timestampMax;
    private String title;
    private String description;
    private RfcState state;
    private Employee manager;
    private RfcCategory category;
    private RfcPriority priority;
    private RfcImpact impact;
    private RfcResolution resolution;
    private boolean allowEmptyQueries;
    

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
     * @return the timestampMin
     */
    public Date getTimestampMin() {
        return timestampMin;
    }

    /**
     * @param timestampMin the timestampMin to set
     */
    public void setTimestampMin(Date timestampMin) {
        this.timestampMin = timestampMin;
    }

    /**
     * @return the timestampMax
     */
    public Date getTimestampMax() {
        return timestampMax;
    }

    /**
     * @param timestampMax the timestampMax to set
     */
    public void setTimestampMax(Date timestampMax) {
        this.timestampMax = timestampMax;
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
            allowEmptyQueries        
            || id != null
            || state != null
            || creator != null
            || timestampMin != null
            || timestampMax != null
            || StringUtils.hasText(title)
            || StringUtils.hasText(description)
            || priority != null
            || category != null
            || resolution != null    
            || impact != null;     
    }

    /**
     * @return the queryWhenEmpty
     */
    public boolean isAllowEmptyQueries() {
        return allowEmptyQueries;
    }

    /**
     * @param queryWhenEmpty the queryWhenEmpty to set
     */
    public void setAllowEmptyQueries(boolean queryWhenEmpty) {
        this.allowEmptyQueries = queryWhenEmpty;
    }

    /**
     * @return the category
     */
    public RfcCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(RfcCategory category) {
        this.category = category;
    }

    /**
     * @return the resolution
     */
    public RfcResolution getResolution() {
        return resolution;
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(RfcResolution resolution) {
        this.resolution = resolution;
    }
}
