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
import servicedesk.core.base.client.domain.Client;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="CLIENT_USERS")
@PrimaryKeyJoinColumn(name="USER_ID")
public class ClientUser extends User  {
     private Client client;

    /**
     * @return the client
     */
    @OneToOne
    @JoinColumn(name="CLIENT_ID")
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @Transient
    @Override
    public Person getPerson() {
        return client;
    }

    @Override
    public <R,C> R accept(UserVisitor<R,C> visitor, C context) {
        return visitor.visit(this, context);
    }
}
