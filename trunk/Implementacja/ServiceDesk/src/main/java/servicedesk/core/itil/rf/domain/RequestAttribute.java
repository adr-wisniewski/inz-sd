package servicedesk.core.itil.rf.domain;

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
@Table(name = "REQUEST_ATTRIBUTES")
public class RequestAttribute {
	@Id
	@SequenceGenerator(name = "attribute_seq", sequenceName = "REQ_ATTR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_seq")
	@Column(name = "ATTRIBUTE_ID")
	private Integer id;
	
	@Column(name = "VALUE")
	private String value;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REQUEST_ID")
	private ServiceRequest request;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TYPE_CODE")
	private RequestAttributeType attributeType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ServiceRequest getRequest() {
		return request;
	}

	public void setRequest(ServiceRequest request) {
		this.request = request;
	}

	public RequestAttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(RequestAttributeType attributeType) {
		this.attributeType = attributeType;
	}
}
