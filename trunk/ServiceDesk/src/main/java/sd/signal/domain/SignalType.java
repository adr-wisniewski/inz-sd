package sd.signal.domain;

import java.io.Serializable;
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

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="SIGNAL_TYPES")
public class SignalType implements DictionaryProperty<Integer>, Serializable{
	@Id
	@SequenceGenerator(name = "signal_type_seq", sequenceName = "SIGNAL_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "signal_type_seq")
	@Column(name="TYPE_CODE")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MSG_TEMPLATE")
	private String messageTemplate;
	
	@Column(name="SUBJECT_TEMPLATE")
	private String subjectTemplate;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SIGNIFICANCE_CODE")
	private SignalSignificanceType significance;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="OBJECT_CODE")
	private SignalObjectType objectType;

    @Override
	public Integer getId() {
		return id;
	}

    @Override
	public void setId(Integer id) {
		this.id = id;
	}

    @Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

	public String getSubjectTemplate() {
		return subjectTemplate;
	}

	public void setSubjectTemplate(String subjectTemplate) {
		this.subjectTemplate = subjectTemplate;
	}

	public SignalSignificanceType getSignificance() {
		return significance;
	}

	public void setSignificance(SignalSignificanceType significance) {
		this.significance = significance;
	}

	public SignalObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(SignalObjectType objectType) {
		this.objectType = objectType;
	}

	@Override
	public String toString() {
		return "SignalType [id=" + id + ", messageTemplate="
				+ messageTemplate + ", name=" + name + ", objectType="
				+ objectType + ", significance=" + significance
				+ ", subjectTemplate=" + subjectTemplate + "]";
	}

    @Override
	public String getCode() {
		return Integer.toString(id);
	}
}
