/*package sd.cmdb.domain.old;

import sd.cmdb.domain.ItemType;
import sd.cmdb.domain.Quantity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="C2_RELATION_CLASSES")
@PrimaryKeyJoinColumn(name="CLASS_ID")
public class RelationClazz extends Clazz {
	
	private Quantity quantity;
	private String nameReverse;
	private ItemType sourceType;
	private ItemType targetType;
	private ItemClass sourceClazz;
	private ItemClass targetClazz;
	
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
	
	@Column(name="QUANTITY", length=1)
	@Enumerated(EnumType.STRING)
	public Quantity getQuantity() {
		return quantity;
	}
	
	public void setNameReverse(String nameReverse) {
		this.nameReverse = nameReverse;
	}
	
	@Column(name="NAME_REVERSE", length=200)
	public String getNameReverse() {
		return nameReverse;
	}
	
	public void setSourceType(ItemType sourceType) {
		this.sourceType = sourceType;
	}
	
	@Column(name="SOURCE_TYPE", length=3)
	@Enumerated(EnumType.STRING)
	public ItemType getSourceType() {
		return sourceType;
	}
	
	public void setTargetType(ItemType targetType) {
		this.targetType = targetType;
	}
	
	@Column(name="TARGET_TYPE", length=3)
	@Enumerated(EnumType.STRING)
	public ItemType getTargetType() {
		return targetType;
	}
	
	public void setSourceClazz(ItemClass sourceClazz) {
		this.sourceClazz = sourceClazz;
	}
	
	@ManyToOne
	@JoinColumn(name="SOURCE_CLASS_ID")
	public ItemClass getSourceClazz() {
		return sourceClazz;
	}
	
	public void setTargetClazz(ItemClass targetClazz) {
		this.targetClazz = targetClazz;
	}
	
	@ManyToOne
	@JoinColumn(name="TARGET_CLASS_ID")
	public ItemClass getTargetClazz() {
		return targetClazz;
	};
}

 *
 */