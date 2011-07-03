/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.client.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.base.security.domain.Person;
import servicedesk.core.base.security.domain.User;

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
}
