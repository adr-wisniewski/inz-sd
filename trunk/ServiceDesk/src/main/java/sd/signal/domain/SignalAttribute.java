package sd.signal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SIGNAL_ATTRIBUTES")
public class SignalAttribute {
	@Id
	@SequenceGenerator(name = "SIGNAL_PARAM_ID_SEQ", sequenceName = "SIGNAL_PARAM_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIGNAL_PARAM_ID_SEQ")
	@Column(name="ATTRIBUTE_ID")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SIGNAL_ID")
	private Signal signal;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ATTRIBUTE_CODE")
	private SignalObjectAttributeType attributeType;
	
	@Column(name="ATTRIBUTE_VALUE")
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	public SignalObjectAttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(SignalObjectAttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SignalAttribute [attributeType=" + attributeType + ", id=" + id
				+ ", signal=" + signal + ", value=" + value + "]";
	}
}
