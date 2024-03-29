/**
 * 
 */
package servicedesk.core.itil.im.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import servicedesk.infrastructure.interfaces.domain.DictionaryProperty;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "CATEGORIES_IM")
public class IncidentCategory implements DictionaryProperty<String>, HierarchicalDomainObject<String>, Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @Column(name = "CATEGORY_CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "parent_category")
    @ManyToOne
    private IncidentCategory parent;
    @OneToMany(mappedBy = "parent")
    private List<IncidentCategory> children;

    /** 
     * /**
     *  * @return the code
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public String getCode() {
        // begin-user-code
        return code;
        // end-user-code
    }

    /** 
     * /**
     *  * @param code the code to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setCode(String code) {
        // begin-user-code
        this.code = code;
        // end-user-code
    }

    /** 
     * /**
     *  * @return the name
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public String getName() {
        // begin-user-code
        return name;
        // end-user-code
    }

    /** 
     * /**
     *  * @param name the name to set
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setName(String name) {
        // begin-user-code
        this.name = name;
        // end-user-code
    }

    public IncidentCategory() {
        //nothing
    }

    public IncidentCategory(String code, String name) {
        super();
        this.code = code;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof IncidentCategory)) {
            return false;
        }
        final IncidentCategory other = (IncidentCategory) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }

    /**
     * 
     */
    @Override
    public String getId() {
        return code;
    }

    public void setId(String code) {
        this.code = code;
    }

    /**
     * @return the parent
     */
    @Override
    public IncidentCategory getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(IncidentCategory parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public List<IncidentCategory> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<IncidentCategory> children) {
        this.children = children;
    }
}