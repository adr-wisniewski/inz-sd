package sd.tree.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import sd.cmdb.dao.UniversalItemClassDao;

import sd.em.dao.EventCategoryDao;
import sd.im.dao.IncidentCategoryDao;
import sd.pm.dao.ProblemCategoryDao;
import sd.rf.dao.RequestCategoryDao;
import sd.infrastructure.dao.HierarchyDao;
import sd.infrastructure.domain.HierarchicalDomainObject;
import sd.tree.NullHierarchyItem;
import sd.tree.app.TreeBuilder;

@Controller
@SessionAttributes({"source", "name"})
public class TreePickerController {

        @Autowired
        protected ConversionService conversionService;

	private Map<String, HierarchyDao<?, ?>> dataSources = new HashMap<String, HierarchyDao<?, ?>>();
	
	public void registerDataSource(String dataSourceName, HierarchyDao<?, ?> dao) {
		this.dataSources.put(dataSourceName, dao);
	}

	@Autowired
	public void setIncidentCategoryDao(IncidentCategoryDao dao) {
		registerDataSource("categories_im", dao);
	}
	
	@Autowired
	public void setProblemCategoryDao(ProblemCategoryDao dao) {
		registerDataSource("categories_pm", dao);
	}
	
	@Autowired
	public void setEventCategoryDao(EventCategoryDao dao) {
		registerDataSource("categories_em", dao);
	}
	
	@Autowired
	public void setRequestCategoryDao(RequestCategoryDao dao) {
		registerDataSource("categories_rf", dao);
	}

        @Autowired
	public void setItemClassDao(UniversalItemClassDao dao) {
            registerDataSource("itemclass_cmdb", dao);
	}
	
	public HierarchyDao<?, ?> getDataSource(String dataSourceName) {
		return this.dataSources.get(dataSourceName);
	}
	
	@RequestMapping(value="/sd/treePicker", method = RequestMethod.GET)
	public String showView(ModelMap model, @RequestParam("source") String dataSourceName, @RequestParam("name") String name, @RequestParam("value") String value) {
		model.addAttribute("source", dataSourceName);
		model.addAttribute("name", name);
		model.addAttribute("roots", TreeBuilder.buildTree(getDataSource(dataSourceName).getAll(), value));
		return "sd/treePicker";
	}
	
	@RequestMapping(value="/sd/treePickerChoose", method = RequestMethod.GET)
	public String onChoose(ModelMap model, @RequestParam("id") String itemId, @ModelAttribute("source") String dataSourceName) {

            HierarchicalDomainObject<?> item = NullHierarchyItem.INSTANCE;

            if(!itemId.equals("null")) {

                HierarchyDao<?, ?> dao = getDataSource(dataSourceName);
                Class<? extends Serializable> targetClass = dao.getIdClass();
                item = omg(targetClass, dao, itemId);
            }

            model.addAttribute("item", item);
            return "sd/treePickerChoose";
	}

        private <Id extends Serializable> HierarchicalDomainObject<Id>
                omg(Class<Id> clazz, HierarchyDao<?, ?> dao, String itemId) {
            HierarchyDao<?, Id> typedDao = (HierarchyDao<?, Id>)dao;
            return typedDao.get(conversionService.convert(itemId, clazz));
        }
}
