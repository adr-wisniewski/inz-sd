package servicedesk.signal.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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
import javax.persistence.Temporal;

import org.hibernate.annotations.Type;
import servicedesk.infrastructure.general.domain.DomainObject;

@Entity
@Table(name="SIGNAL_GENERATORS")
public class SignalGenerator implements DomainObject<Integer>, Serializable {
	@Column(name="CRITERION")
	private String criterion;
	
	@Column(name="ENABLED")
	@Type(type = "true_false")
	private Boolean enabled;

	@Column(name="ERROR_MESSAGE")
	private String errorMessage;
	
	@Column(name="FREQUENCY")
	private Integer frequency;
	
	@Id
	@SequenceGenerator(name = "signal_generator_seq", sequenceName = "SIGNAL_GENERATOR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "signal_generator_seq")
	@Column(name="GENERATOR_ID")
	private Integer id;
	
	@Column(name="LAST_RUN_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date lastRunDate;
	
	@Column(name="LAST_RUN_STATUS")
	@Type(type = "true_false")
	private Boolean lastRunStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="RECEIVER_CODE")
	private SignalReceiverType receiverType;
	
	@Column(name="SELECT_STATEMENT")
	private String selectStatement;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TYPE_CODE")
	private SignalType type;
	
	private String getCheckDuplicateCondition() {
		return "not exists (select * from signals where type_code = " + type.getCode() +  " and object_id = o." + type.getObjectType().getIdColumnName() + ")";
	}

	public String getCriterion() {
		return criterion;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Integer getFrequency() {
		return frequency;
	}

    @Override
	public Integer getId() {
		return id;
	}

	public Date getLastRunDate() {
		return lastRunDate;
	}

	public Boolean getLastRunStatus() {
		return lastRunStatus;
	}

	public Date getNextRunDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(lastRunDate);
		c.add(Calendar.MINUTE, frequency);
		return c.getTime(); 
	}

	public String getQuery() {
		return  "select " + selectStatement + " from " +
				type.getObjectType().getViewName() + " o " + receiverType.getFromStatement() +
				" where " + criterion + " and " + getCheckDuplicateCondition()
		;
	}

	public SignalReceiverType getReceiverType() {
		return receiverType;
	}

	public String getSelectStatement() {
		return selectStatement;
	}

	public SignalType getType() {
		return type;
	}

	public Boolean isLastRunStatus() {
		return lastRunStatus;
	}

	/**
	 * 
	 * @return czy generator jest gotowy
	 */
	public boolean isReady() {
		if(enabled) {
			return getNextRunDate().compareTo(new Date()) < 0;
		}
		
		return false;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}
	public void setLastRunStatus(Boolean lastRunStatus) {
		this.lastRunStatus = lastRunStatus;
	}
	
	public void setReceiverType(SignalReceiverType receiverType) {
		this.receiverType = receiverType;
	}
	
	public void setSelectStatement(String selectStatement) {
		this.selectStatement = selectStatement;
	}
	
	public void setType(SignalType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "SignalGenerator [criterion=" + criterion + ", id=" + id
				+ ", lastRunDate=" + lastRunDate + ", lastRunStatus="
				+ lastRunStatus + ", receiverType=" + receiverType
				+ ", selectStatement=" + selectStatement + ", type=" + type
				+ "]";
	}
}
