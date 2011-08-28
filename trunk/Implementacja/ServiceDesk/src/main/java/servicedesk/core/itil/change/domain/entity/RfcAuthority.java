/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.infrastructure.interfaces.domain.NamedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "RFC_AUTHORITIES")
@NamedQueries({
    @NamedQuery(name="RfcAuthority.isMember", query=
        "select count(*)"
        + " from RfcAuthority as rfcAuthority"
            + " join rfcAuthority.members as member with employee_id = :employeeId"
        + " where rfcAuthority.id = :rfcAuthorityId"),
    @NamedQuery(name="RfcAuthority.getForCategory", query=
        "select rfcAuthority" 
        + " from RfcAuthority as rfcAuthority"
            + " join rfcAuthority.categories as category with category_id = :categoryId"),
    @NamedQuery(name="RfcAuthority.getCabsForCategory", query=
        "select rfcAuthority" 
        + " from RfcAuthority as rfcAuthority"
            + " join rfcAuthority.categories as category with category_id = :categoryId"
        + " where rfcAuthority.cab = true")      
})
public class RfcAuthority implements NamedDomainObject<Integer>, Serializable {
    private Integer id;
    private String name;
    private boolean cab;
    private List<Employee> members;
    private List<RfcCategory> categories;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "RFC_AUTHORITIES_SEQ", sequenceName = "RFC_AUTHORITIES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_AUTHORITIES_SEQ")
    @Column(name="AUTHORITY_ID")
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name="NAME")
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the members
     */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="RFC_AUTHORITY_MEMBERS",
        joinColumns=@JoinColumn(name="AUTHORITY_ID"),
        inverseJoinColumns=@JoinColumn(name="EMPLOYEE_ID")
    )
    public List<Employee> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<Employee> members) {
        this.members = members;
    }

    /**
     * @return the categories
     */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="RFC_AUTHORITY_CATEGORIES",
        joinColumns=@JoinColumn(name="AUTHORITY_ID"),
        inverseJoinColumns=@JoinColumn(name="CATEGORY_ID")
    )
    public List<RfcCategory> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<RfcCategory> categories) {
        this.categories = categories;
    }

    /**
     * @return the cab
     */
    @Column(name="IS_CAB")
    @Type(type="yes_no")
    public boolean isCab() {
        return cab;
    }

    /**
     * @param cab the cab to set
     */
    public void setCab(boolean cab) {
        this.cab = cab;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RfcAuthority)) {
            return false;
        }
        final RfcAuthority other = (RfcAuthority) obj;
        if ((this.getName() == null) ? (other.getName() != null) : !this.getName().equals(other.getName())) {
            return false;
        }
        if (this.isCab() != other.isCab()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 * hash + (this.cab ? 1 : 0);
        return hash;
    }
    
    
}
