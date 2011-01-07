/*package sd.cmdb.domain.old;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@DiscriminatorValue("ENT")
@SecondaryTable(name = "CIENTITY")
public class BaseItem {
	private BaseItem parent;
	private Set<BaseItem> children;

	void setParent(BaseItem parent) {
		this.parent = parent;
	}

	@ManyToOne
	@JoinColumn(name="PARENT_CIID")
	BaseItem getParent() {
		return parent;
	}

	void setChildren(Set<BaseItem> children) {
		this.children = children;
	}

	@OneToMany(mappedBy="parent")
	@Cascade(value = {CascadeType.DELETE_ORPHAN})
	Set<BaseItem> getChildren() {
		return children;
	}
}

 *
 */