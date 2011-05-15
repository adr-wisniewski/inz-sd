/**
 * 
 */
package servicedesk.pm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import servicedesk.dictionary.DictionaryProperty;
import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "CATEGORIES_PM")
public class ProblemCategory implements DictionaryProperty<String>, HierarchicalDomainObject<String>, Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @Column(name = "CATEGORY_CODE")
    private String code;
    @JoinColumn(name = "parent_category")
    @ManyToOne
    private ProblemCategory parent;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "parent")
    private List<ProblemCategory> children;

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
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProblemCategory other = (ProblemCategory) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }

    public ProblemCategory() {
        //nothing
    }

    public ProblemCategory(String code, String name) {
        super();
        this.code = code;
        this.name = name;
    }

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
    public ProblemCategory getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(ProblemCategory parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    @Override
    public List<ProblemCategory> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<ProblemCategory> children) {
        this.children = children;
    }
}