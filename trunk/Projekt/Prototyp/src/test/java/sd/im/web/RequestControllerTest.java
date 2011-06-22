package sd.im.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import sd.im.app.Request;
import sd.im.app.RequestDao;
import sd.im.app.RequestSearchCriteria;
import sd.im.impl.InMemoryRequestDao;
import sd.im.impl.RequestServiceImpl;

public class RequestControllerTest {
	private RequestController instance;
	private RequestServiceImpl requestService;
	private RequestDao requestDao;
	
	@Before
	public void setUp() throws Exception {
		requestDao = new InMemoryRequestDao();
		
		requestService = new RequestServiceImpl();
		requestService.setRequestDao(requestDao);
		
		instance = new RequestController();
		instance.setRequestService(requestService);
	}

	@Test
	public void testSearch() {
		RequestSearchCriteria searchCriteria = new RequestSearchCriteria();
		searchCriteria.setSubject("r1");
		
		ModelAndView mv = instance.searchPOST(searchCriteria);
		assertEquals("im/search", mv.getViewName());
		Set requests = (Set)mv.getModelMap().get("requests");
		assertEquals(2, requestDao.findAll().size());
		assertNotNull(requests);
		assertEquals(1, requests.size());
	}

	@Test
	public void testAddForm() {
		String viewName = instance.addForm(null);
		assertEquals("im/add", viewName);
	}

	@Test
	public void testAdd() {
		Request r = new Request();
		r.setSubject("r3");
		String viewName = instance.add(r);
		assertEquals("im/add", viewName);
	}

	@Test
	public void testEditResolution() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttachFile() {
		fail("Not yet implemented");
	}

}
