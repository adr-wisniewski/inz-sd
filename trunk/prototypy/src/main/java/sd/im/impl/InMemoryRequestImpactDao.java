package sd.im.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import sd.im.app.RequestImpact;
import sd.im.app.RequestImpactDao;

@Repository
public class InMemoryRequestImpactDao implements RequestImpactDao {

	public List<RequestImpact> fetchAll() {
		return Arrays.asList(
				new RequestImpact[] {
						new RequestImpact("USER", "Uzytkownik"),
						new RequestImpact("GROUP", "Grupa"),
						new RequestImpact("COMPANY", "Firma")
				}
		);
	}

}
