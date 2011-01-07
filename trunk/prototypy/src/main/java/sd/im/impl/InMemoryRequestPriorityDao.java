package sd.im.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.im.app.RequestPriority;
import sd.im.app.RequestPriorityDao;

@Repository
public class InMemoryRequestPriorityDao implements RequestPriorityDao {

	public List<RequestPriority> fetchAll() {
		return Arrays.asList(
				new RequestPriority[] {
						new RequestPriority(1, "Low"),
						new RequestPriority(2, "Medium"),
						new RequestPriority(3, "High")
				}
		);
	}

}
