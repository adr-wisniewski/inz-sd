/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.helper;

import java.util.Date;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.core.itil.change.domain.entity.RfcImpact;
import servicedesk.core.itil.change.domain.entity.RfcPriority;
import servicedesk.core.itil.change.domain.entity.RfcResolution;
import servicedesk.core.itil.change.domain.entity.RfcState;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.infrastructure.search.SearchObject;
import servicedesk.infrastructure.search.Range;
import servicedesk.infrastructure.search.annotations.AllowEmptySearch;

/**
 *
 * @author Adrian
 */
@AllowEmptySearch
public class RfcSearchObject implements SearchObject<Rfc> {
    private Integer id;
    private User creator;
    private Range<Date> timestamp = new Range<Date>();
    private String title;
    private String description;
    private RfcState state;
    private Employee manager;
    private RfcCategory category;
    private RfcPriority priority;
    private RfcImpact impact;
    private RfcResolution resolution;
    

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
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(User creator) {
        this.creator = creator;
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

    /**
     * @return the timestamp
     */
    public Range<Date> getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Range<Date> timestamp) {
        this.timestamp = timestamp;
    }
}
