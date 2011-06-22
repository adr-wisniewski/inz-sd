package sd.im.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import sd.im.app.RequestStatus;
import sd.im.app.RequestStatusDao;

@Repository
public class InMemoryRequestStatusDaoImpl implements RequestStatusDao {
	private List<RequestStatus> statuses;
	
	public InMemoryRequestStatusDaoImpl() {
		this.statuses = Arrays.asList(
				new RequestStatus[] {
						new RequestStatus("OPEN", "Otwarty"),
						new RequestStatus("CLOSED", "Zamkniety"),
						new RequestStatus("ONHOLD", "W trakcie")
				}
		);
	}
	
	public List<RequestStatus> fetchAll() {
		return this.statuses;
	}

}
