/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.base.cooperant.domain.Cooperant;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="COOPERANT_USERS")
@PrimaryKeyJoinColumn(name="USER_ID")
public class CooperantUser extends User {
    private Cooperant cooperant;

    /**
     * @return the cooperant
     */
    @OneToOne
    @JoinColumn(name="COOPERANT_ID")
    public Cooperant getCooperant() {
        return cooperant;
    }

    /**
     * @param cooperant the cooperant to set
     */
    public void setCooperant(Cooperant cooperant) {
        this.cooperant = cooperant;
    }

    @Transient
    @Override
    public Person getPerson() {
        return cooperant;
    }
    
    @Override
    public <R,C> R accept(UserVisitor<R,C> visitor, C context) {
        return visitor.visit(this, context);
    }
}
