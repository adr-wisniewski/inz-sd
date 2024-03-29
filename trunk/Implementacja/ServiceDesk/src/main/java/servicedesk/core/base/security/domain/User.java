/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="USERS")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(
    @NamedQuery(name="User.findByLogin", query="from User as user where user.login = :login")
)
public abstract class User implements DomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer Id;
    private String login;
    private String password;
    private boolean enabled;
    private Collection<Role> roles;

    /**
     * @return the Id
     */
    @Id
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name = "USER_ID", precision = 10)
    @Override
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the login
     */
    @Column(name = "LOGIN", length = 50)
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    @Column(name = "PASSWORD", length = 50)
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enabled
     */
    @Column(name = "ENABLED", length = 1)
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the employee
     */
    @Transient
    public abstract Person getPerson();

    @Transient
    public String getFirstname() {
        return getPerson().getFirstname();
    }
    
    @Transient
    public String getLastname() {
        return getPerson().getLastname();
    }
    
    /**
     * @return the roles
     */
    @ManyToMany
    @JoinTable(name="USER_ROLE",
        joinColumns=@JoinColumn(name="USER_ID"),
        inverseJoinColumns=@JoinColumn(name="ROLE_CODE"))
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    
    public abstract <R,C> R accept(UserVisitor<R,C> visitor, C context);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }
}
