package sd.web;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	//Logger logger = Logger.getLogger(ReportController.class);
			
	@Autowired
	BasicDataSource dataSource;
	
	@RequestMapping(value = "/report")
	public ModelAndView report(@RequestParam("name") String name, @RequestParam("format") String format) throws SQLException {
		ModelMap map = new ModelMap();
		map.addAttribute("jdbcDataSource", dataSource);
		map.addAttribute("format", format);
		
		return new ModelAndView(name, map);
	}
	
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
}
