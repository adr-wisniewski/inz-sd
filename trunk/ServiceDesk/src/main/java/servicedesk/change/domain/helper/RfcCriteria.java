/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain.helper;

import java.util.Date;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.RfcCategory;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcResolution;
import servicedesk.change.domain.RfcState;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.search.domain.AbstractQuery;
import servicedesk.infrastructure.search.domain.ComparisonType;
import servicedesk.infrastructure.search.domain.SimpleCriterion;

/**
 *
 * @author Adrian
 */
public class RfcCriteria extends AbstractQuery<Rfc> {
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        set("id", new SimpleCriterion(id, ComparisonType.EQUAL));
    }
    
    public Object getId() {
        return get("id");
    }

    /**
     * @param state the state to set
     */
    public void setState(RfcState state) {
        set("state", new SimpleCriterion(state, ComparisonType.EQUAL));
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(Employee creator) {
        set("creator", new SimpleCriterion(creator, ComparisonType.EQUAL));
    }

    /**
     * @param timestampMin the timestampMin to set
     */
    public void setTimestampMin(Date timestampMin) {
        set("timestamp", new SimpleCriterion(timestampMin, ComparisonType.GREATER_EQUAL));
    }

    /**
     * @param timestampMax the timestampMax to set
     */
    public void setTimestampMax(Date timestampMax) {
        set("timestamp", new SimpleCriterion(timestampMax, ComparisonType.LESS_EQUAL));
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        set("timestamp", new SimpleCriterion(title, ComparisonType.LIKE));
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        set("description", new SimpleCriterion(description, ComparisonType.LIKE));
    }


    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        set("manager", new SimpleCriterion(manager, ComparisonType.EQUAL));
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(RfcPriority priority) {
        set("priority", new SimpleCriterion(priority, ComparisonType.EQUAL));
    }

    /**
     * @param impact the impact to set
     */
    public void setImpact(RfcImpact impact) {
        set("impact", new SimpleCriterion(impact, ComparisonType.EQUAL));
    }


    /**
     * @param category the category to set
     */
    public void setCategory(RfcCategory category) {
        set("category", new SimpleCriterion(category, ComparisonType.EQUAL));
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(RfcResolution resolution) {
        set("resolution", new SimpleCriterion(resolution, ComparisonType.EQUAL));
    }
}
