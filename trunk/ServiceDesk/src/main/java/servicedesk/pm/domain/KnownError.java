package servicedesk.pm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import servicedesk.infrastructure.general.domain.DomainObject;

@Entity
@Table(name="KNOWN_ERRORS_V")
public class KnownError implements DomainObject<Integer>, Serializable {
	@Id
	@Column(name="PROBLEM_ID")
	private Integer id;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="SYMPTOMS")
	private String symptoms;
	
	@Column(name="ROOT_CAUSE")
	private String rootCause;
	
	@Column(name="WORKAROUND")
	private String workaround;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CATEGORY_CODE")
	private ProblemCategory category;

        @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getWorkaround() {
		return workaround;
	}

	public void setWorkaround(String workaround) {
		this.workaround = workaround;
	}

	public ProblemCategory getCategory() {
		return category;
	}

	public void setCategory(ProblemCategory category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KnownError other = (KnownError) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KnownError [category=" + category + ", id=" + id
				+ ", rootCause=" + rootCause + ", subject=" + subject
				+ ", symptoms=" + symptoms + ", workaround=" + workaround + "]";
	}
	
}
