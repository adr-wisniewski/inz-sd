package sd.cmdb.domain;

public enum ItemType {
	GENERIC {
            @Override
	    public String toString() {
	        return "GEN";
	    }
	},
	
	EMPLOYEE {
            @Override
	    public String toString() {
	        return "EMP";
	    }
	},
	
	RFC {
            @Override
	    public String toString() {
	        return "RFC";
	    }
	},
	
	PROBLEM {
            @Override
	    public String toString() {
	        return "PRB";
	    }
	},
	
	INCIDENT {
            @Override
	    public String toString() {
	        return "INC";
	    }
	},
}
/*
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CIITEM_TYPE")
@NamedQueries({
    @NamedQuery(
    	name = "findByName", 
		query = "from ItemType as itemType where itemType.name = :name"
	)
})
public class ItemType {
	
	private Integer			id;
	private ItemType 		parent;
	private Set<ItemType>	children;
	private String 			name;
	private Boolean 		abstractType;
	private String 			iconBigUrl;
	private String 			iconSmallUrl;
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@SequenceGenerator(name = "CIITEM_TYPE_SEQ", sequenceName = "CIITEM_TYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIITEM_TYPE_SEQ")
	@Column(name="ITEM_TYPE_ID")
	public Integer getId() {
		return id;
	}

	public void setParent(ItemType parent) {
		this.parent = parent;
	}
	
	@ManyToOne
	@JoinColumn(name="PARENT_ITEM_TYPE_ID")
	public ItemType getParent() {
		return parent;
	}
	
	public void setChildren(Set<ItemType> children) {
		this.children = children;
	}
	
	@OneToMany(mappedBy="parent")
	@Cascade(value = {CascadeType.DELETE_ORPHAN})
	public Set<ItemType> getChildren() {
		return children;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setAbstractType(Boolean abstractType) {
		this.abstractType = abstractType;
	}
	
	@Column(name = "ISABSTRACT")
	@org.hibernate.annotations.Type(type="yes_no")
	public Boolean getAbstractType() {
		return abstractType;
	}
	
	public void setIconBigUrl(String iconBigUrl) {
		this.iconBigUrl = iconBigUrl;
	}
	
	@Column(name = "ICON_BIG_URL")
	public String getIconBigUrl() {
		return iconBigUrl;
	}
	public void setIconSmallUrl(String iconSmallUrl) {
		this.iconSmallUrl = iconSmallUrl;
	}
	
	@Column(name = "ICON_SMALL_URL")
	public String getIconSmallUrl() {
		return iconSmallUrl;
	}

	@Override
	public boolean equals(Object obj) {
		
		if ( this == obj ) 
			return true;
		
		if ( !(obj instanceof ItemType) ) 
			return false;

		ItemType that = (ItemType)obj;
		return name != null && name.equals(that.name);
	}
}
*/