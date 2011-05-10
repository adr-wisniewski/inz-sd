/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain;

import servicedesk.change.domain.helper.Changeable;
import servicedesk.domain.Employee;

/**
 *
 * @author Adrian
 */
public class RfcChange {
    private RfcChangeType changeType;
    private Changeable<String> title;
    private Changeable<String> description;
    private Changeable<RfcPriority> priority;
    private Changeable<RfcImpact> impact;
    private Changeable<RfcState> state;
    private Changeable<Employee> manager;

    public RfcChange() {
        
    }
    
    public RfcChange(RfcChangeType changeType, Rfc previous, Rfc next) {
        this.changeType = changeType;
        title = new Changeable<String>(previous.getTitle(), next.getTitle());
        description = new Changeable<String>(previous.getDescription(), next.getDescription());
        priority = new Changeable<RfcPriority>(previous.getPriority(), next.getPriority());
        impact = new Changeable<RfcImpact>(previous.getImpact(), next.getImpact());
        state = new Changeable<RfcState>(previous.getState(), next.getState());
        manager = new Changeable<Employee>(previous.getManager(), next.getManager());
    }
    
    /**
     * @return the changeType
     */
    public RfcChangeType getChangeType() {
        return changeType;
    }

    /**
     * @param changeType the changeType to set
     */
    public void setChangeType(RfcChangeType changeType) {
        this.changeType = changeType;
    }

    /**
     * @return the title
     */
    public Changeable<String> getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Changeable<String> title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public Changeable<String> getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Changeable<String> description) {
        this.description = description;
    }

    /**
     * @return the priority
     */
    public Changeable<RfcPriority> getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Changeable<RfcPriority> priority) {
        this.priority = priority;
    }

    /**
     * @return the impact
     */
    public Changeable<RfcImpact> getImpact() {
        return impact;
    }

    /**
     * @param impact the impact to set
     */
    public void setImpact(Changeable<RfcImpact> impact) {
        this.impact = impact;
    }

    /**
     * @return the state
     */
    public Changeable<RfcState> getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Changeable<RfcState> state) {
        this.state = state;
    }

    /**
     * @return the manager
     */
    public Changeable<Employee> getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Changeable<Employee> manager) {
        this.manager = manager;
    }
}
