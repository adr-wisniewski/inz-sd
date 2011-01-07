package sd.signal.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="SIGNAL_RECEIVER_TYPES")
public class SignalReceiverType implements DictionaryProperty<String>, Serializable {
	@Id
	@Column(name="RECEIVER_CODE")
	private String code;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="FROM_STATEMENT")
	private String fromStatement;
	
    @Override
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFromStatement() {
		return fromStatement;
	}
	
	public void setFromStatement(String fromStatement) {
		this.fromStatement = fromStatement;
	}
	
	@Override
	public String toString() {
		return "SignalReceiverType [description=" + description
				+ ", fromStatement=" + fromStatement + ", code=" + code + "]";
	}

    @Override
	public String getName() {
		return description;
	}

    @Override
    public String getId() {
        return getCode();
    }

    @Override
    public void setId(String id) {
        setCode(id);
    }
}
