package sd.signal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="SIGNAL_SIGNIFICANCE_TYPES")
public class SignalSignificanceType implements DictionaryProperty {
	@Id
	@Column(name="SIGNIFICANCE_CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CSS_CLASS")
	private String cssClass;
	
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
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	@Override
	public String toString() {
		return "SignalSignificanceType [code=" + code + ", name=" + name + "]";
	}
}
