package sd.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import sd.dictionary.DictionaryProperty;

@Entity
@Table(name="ROLES")
@NamedQueries({
    @NamedQuery(name = "Role.findByCode", query = "SELECT r FROM Role r WHERE r.code = ?")})
public class Role implements DictionaryProperty<String>, Serializable {
	
	@Id
	@Column(name="ROLE_CODE")
	private String code;
	
        @Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
