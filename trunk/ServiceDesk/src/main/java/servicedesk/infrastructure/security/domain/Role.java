package servicedesk.infrastructure.security.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import servicedesk.dictionary.DictionaryProperty;

@Entity
@Table(name="ROLES")
@NamedQueries({
    @NamedQuery(name = "Role.findByCode", query = "SELECT r FROM Role r WHERE r.code = ?")})
public class Role implements DictionaryProperty<String>, Serializable {
    private String code;
    private String description;
    private Collection<Privilege> privileges;

    @Id
    @Column(name="ROLE_CODE")
    @Override
    public String getCode() {
            return code;
    }

    public void setCode(String code) {
            this.code = code;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
            return description;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    @Transient
    @Override
    public String getName() {
            return description;
    }

    @Transient
    @Override
    public String getId() {
        return getCode();
    }

    public void setId(String id) {
        setCode(id);
    }

    /**
     * @return the privileges
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="ROLE_PRIVILEGE",
        joinColumns=@JoinColumn(name="ROLE_CODE"),
        inverseJoinColumns=@JoinColumn(name="PRIVILEGE_CODE"))
    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    /**
     * @param privileges the privileges to set
     */
    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.code != null ? this.code.hashCode() : 0);
        return hash;
    }
}
