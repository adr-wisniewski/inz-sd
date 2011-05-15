/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.cmdb.domain.helper.ItemVisitor;
import servicedesk.im.domain.Incident;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_INCIDENT")
public class IncidentItem extends Item {
    private static final long serialVersionUID = 1L;
    private Incident incident;
    private IncidentItemClass incidentItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "INCIDENT_ID")
    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    @Override
    @Transient
    public IncidentItemClass getItemClass() {
        return incidentItemClass;
    }

    public void setItemClass(IncidentItemClass incidentItemClass) {
        this.incidentItemClass = incidentItemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(incident.getSubject()).append(" ");
        builder.append(incident.getDescription()).append(" ");
        return builder.toString();
    }
}
