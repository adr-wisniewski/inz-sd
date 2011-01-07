/*
package sd.cmdb.domain.old;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="C2_CLASSES")
abstract public class Clazz 
{
	private Integer id;
	
	private Clazz parent;
	private Set<Clazz> children;
	
	private boolean abztract;
	private String name;
	private String description;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id
	@SequenceGenerator(name = "C2_CLASS_SEQ", sequenceName = "C2_CLASS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_CLASS_SEQ")
	@Column(name="CLASS_ID")
	public Integer getId() {
		return id;
	}
	
	public void setParent(Clazz parent) {
		this.parent = parent;
	}
	
	@ManyToOne
	@JoinColumn(name="PARENT_CLASS_ID")
	public Clazz getParent() {
		return parent;
	}
	
	public void setChildren(Set<Clazz> children) {
		this.children = children;
	}

	@OneToMany(mappedBy="parent")
	@Cascade(value = {CascadeType.DELETE_ORPHAN})
	public Set<Clazz> getChildren() {
		return children;
	}

	public void setAbztract(boolean abztract) {
		this.abztract = abztract;
	}

	@Column(name="IS_ABSTRACT", length=1)
	@Type(type="yes_no")
	public boolean getAbztract() {
		return abztract;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="NAME", length=200)
	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="DESCRIPTION", length=2000)
	public String getDescription() {
		return description;
	}


	
	
}
*/