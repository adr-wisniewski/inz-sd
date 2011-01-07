package sd.em.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="EVENT_SIGNIFICANCE_TYPES")
public class EventSignificance implements DictionaryProperty {
	public static final EventSignificance INFO = new EventSignificance("INFO", "INFO");
	
	public static final EventSignificance WARNING = new EventSignificance("WARN", "WARN");
	
	public static final EventSignificance EXCEPTION = new EventSignificance("EXCE", "EXCE");
	
	@Id
	@Column(name="SIGNIFICANCE_CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public EventSignificance() {
		//nothing
	}
	
	public EventSignificance(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EventSignificance other = (EventSignificance) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventSignificance [code=" + code + ", name=" + name + "]";
	}
}
