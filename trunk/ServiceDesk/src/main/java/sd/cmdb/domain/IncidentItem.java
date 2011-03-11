/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import sd.cmdb.domain.helper.ItemVisitor;
import sd.im.domain.Incident;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_INCIDENT")
public class IncidentItem extends Item {
    private Incident incident;
    private IncidentItemClass incidentItemClass;

    /**
     * @return the incident
     */
    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "INCIDENT_ID")
    public Incident getIncident() {
        return incident;
    }

    /**
     * @param incident the incident to set
     */
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
}
