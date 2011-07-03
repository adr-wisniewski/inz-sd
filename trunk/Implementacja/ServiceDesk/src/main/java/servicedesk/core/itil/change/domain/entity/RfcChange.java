/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.util.Date;
import org.hibernate.envers.RevisionType;
import servicedesk.core.itil.change.domain.helper.Changeable;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.history.domain.HistoryRecord;
import servicedesk.core.base.security.domain.User;

/**
 *
 * @author Adrian
 */
public class RfcChange {
    private RevisionType changeType;
    private User instigator;
    private Date timestamp;
    
    private Changeable<String> title;
    private Changeable<String> description;
    private Changeable<RfcPriority> priority;
    private Changeable<RfcImpact> impact;
    private Changeable<RfcCategory> category;
    private Changeable<RfcState> state;
    private Changeable<Employee> manager;
    private Changeable<String> comment;
    
    
    public RfcChange(HistoryRecord<Rfc> record, Rfc previous) {
        changeType = record.getRevisonType();
        instigator = record.getRevison().getInstigator();
        timestamp = record.getRevison().getTimestamp();
        
        initialize(previous, record.getObject());
    }
    
    public final void initialize(Rfc previous, Rfc next) {
        title = new Changeable<String>(previous.getTitle(), next.getTitle());
        description = new Changeable<String>(previous.getDescription(), next.getDescription());
        priority = new Changeable<RfcPriority>(previous.getPriority(), next.getPriority());
        impact = new Changeable<RfcImpact>(previous.getImpact(), next.getImpact());
        category = new Changeable<RfcCategory>(previous.getCategory(), next.getCategory());
        state = new Changeable<RfcState>(previous.getState(), next.getState());
        manager = new Changeable<Employee>(previous.getManager(), next.getManager());
        comment = new Changeable<String>(previous.getComment(), next.getComment());
    }
    
    public boolean isCreated() {
        return changeType == RevisionType.ADD;
    }
    
    public boolean isDeleted() {
        return changeType == RevisionType.DEL;
    }
    
    public boolean isProperitiesChanged() {
        return title.isChanged() 
                || description.isChanged()
                || priority.isChanged()
                || impact.isChanged()
                || state.isChanged()
                || manager.isChanged();
    }
    
    /**
     * @return the changeType
     */
    public RevisionType getChangeType() {
        return changeType;
    }

    /**
     * @param changeType the changeType to set
     */
    public void setChangeType(RevisionType changeType) {
        this.changeType = changeType;
    }

    /**
     * @return the instigator
     */
    public User getInstigator() {
        return instigator;
    }

    /**
     * @param instigator the instigator to set
     */
    public void setInstigator(User instigator) {
        this.instigator = instigator;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
     * @return the category
     */
    public Changeable<RfcCategory> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Changeable<RfcCategory> category) {
        this.category = category;
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

    /**
     * @return the comment
     */
    public Changeable<String> getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(Changeable<String> comment) {
        this.comment = comment;
    }
}
