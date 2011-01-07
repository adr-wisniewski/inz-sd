/*package sd.cmdb.domain.old;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="TYPE",
    length=3,
    discriminatorType=DiscriminatorType.STRING
)
public abstract class Item {
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@SequenceGenerator(name = "CIBASE_SEQ", sequenceName = "CIBASE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIBASE_SEQ")
	@Column(name="CIID")
	public Integer getId() {
		return id;
	}
}

 *
 */