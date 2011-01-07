/*package sd.cmdb.domain.old;

import sd.cmdb.domain.ItemType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CIASSOCIATION_TYPE")
public class AssociationType {
	
	private Integer id;
	private String name;
	private String nameReverse;
	private AssociationQuantity quantity;
	private ItemXType sourceType;
	private ItemXType targetType;
	private ItemType sourceEntityType;
	private ItemType targetEntityType;

	public void setId(Integer id) { 
    	this.id = id; 
    }
	
    @Id
    @SequenceGenerator(name = "CIASSOCIATION_TYPE_SEQ", sequenceName = "CIASSOCIATION_TYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIASSOCIATION_TYPE_SEQ")
    @Column(name="ASSOCIATION_TYPE_ID")
    public Integer getId() { 
    	return id; 
    }
    
	void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "NAME", nullable = false, length = 50)
	String getName() {
		return name;
	}

	void setNameReverse(String nameReverse) {
		this.nameReverse = nameReverse;
	}

	@Column(name = "NAMEREVERSE", length = 50)
	String getNameReverse() {
		return nameReverse;
	}

	void setQuantity(AssociationQuantity quantity) {
		this.quantity = quantity;
	}

	@Column(name = "QUANTITY", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	AssociationQuantity getQuantity() {
		return quantity;
	}

	void setSourceType(ItemXType sourceType) {
		this.sourceType = sourceType;
	}

	@Column(name = "SOURCE_TYPE", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	ItemXType getSourceType() {
		return sourceType;
	}

	void setTargetType(ItemXType targetType) {
		this.targetType = targetType;
	}

	@Column(name = "TARGET_TYPE", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	ItemXType getTargetType() {
		return targetType;
	}

	void setSourceEntityType(ItemType sourceEntityType) {
		this.sourceEntityType = sourceEntityType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SOURCE_ENTITY_TYPE_ID")
	ItemType getSourceEntityType() {
		return sourceEntityType;
	}

	void setTargetEntityType(ItemType targetEntityType) {
		this.targetEntityType = targetEntityType;
	}
	 
	@ManyToOne
	@JoinColumn(name="TARGET_ENTITY_TYPE_ID")
	ItemType getTargetEntityType() {
		return targetEntityType;
	}
}

 *
 */