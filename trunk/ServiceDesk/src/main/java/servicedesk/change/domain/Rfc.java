package servicedesk.change.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RFC")
public class Rfc implements Serializable {
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@SequenceGenerator(name = "RFC_SEQ", sequenceName = "RFC_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_SEQ")
	@Column(name="RFC_ID")
	public Integer getId() {
		return id;
	}
}
