package servicedesk.em.domain;

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
@Table(name = "EVENT_PARAMETERS")
public class EventParameter {
	@Id
	@SequenceGenerator(name = "parameter_seq", sequenceName = "parameter_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_seq")
    @Column(name = "PARAMETER_ID")
	private Integer id;
	
	@Column(name="PARAM_NAME")
	private String name;
	
	@Column(name="PARAM_VALUE")
	private String value;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EVENT_ID")
	private Event event;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "EventParameter [event=" + event + ", id=" + id + ", name="
				+ name + ", value=" + value + "]";
	}
}
