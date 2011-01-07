/*package sd.cmdb.domain.old;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import sd.cm.domain.Rfc;

@Entity
@DiscriminatorValue("RFC")
public class RfcItem {
	private Rfc Rfc;

	void setRfc(Rfc rfc) {
		Rfc = rfc;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RFC_ID")
	Rfc getRfc() {
		return Rfc;
	}
}

 * 
 */