package servicedesk.rf.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import servicedesk.dictionary.DictionaryProperty;
import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;

@Entity
@Table(name = "CATEGORIES_RF")
public class RequestCategory implements DictionaryProperty<String>, HierarchicalDomainObject<String>, Serializable {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "parent")
    private List<RequestCategory> children;

    @Id
    @Column(name = "CATEGORY_CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY")
    private RequestCategory parent;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private List<RequestAttributeType> attributeTypes;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RequestAttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(List<RequestAttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }

    @Override
    public String getId() {
        return code;
    }

    public void setId(String code) {
        this.code = code;
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
        RequestCategory other = (RequestCategory) obj;
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
     * @return the children
     */
    public List<RequestCategory> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<RequestCategory> children) {
        this.children = children;
    }

    /**
     * @return the parent
     */
    @Override
    public RequestCategory getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(RequestCategory parent) {
        this.parent = parent;
    }
}
