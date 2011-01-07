package sd.slm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AGREEMENTS")
public class Agreement {
	@Id
	@Column(name="AGREEMENT_ID")
	private Integer id;
	
	@Column(name="START_HOUR")
	private Integer startHour;
	
	@Column(name="END_HOUR")
	private Integer endHour;
	
	@Column(name="RESOLUTION_TIME")
	private Integer resolutionTime;
	
	@Column(name="AVAILABILITY")
	private double availability;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public Integer getResolutionTime() {
		return resolutionTime;
	}

	public void setResolutionTime(Integer resolutionTime) {
		this.resolutionTime = resolutionTime;
	}

	public double getAvailability() {
		return availability;
	}

	public void setAvailability(double availability) {
		this.availability = availability;
	}
	
	public String getHours() {
		return startHour + ":" + endHour;
	}

}
