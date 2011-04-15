package servicedesk.tree.web;

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
import servicedesk.cmdb.dao.ItemClassDao;
import servicedesk.cmdb.dao.RelationshipClassDao;
import servicedesk.cmdb.dao.UniversalItemClassDao;

import servicedesk.em.dao.EventCategoryDao;
import servicedesk.im.dao.IncidentCategoryDao;
import servicedesk.pm.dao.ProblemCategoryDao;
import servicedesk.rf.dao.RequestCategoryDao;
import servicedesk.infrastructure.dao.HierarchyDao;
import servicedesk.infrastructure.domain.HierarchicalDomainObject;
import servicedesk.tree.NullHierarchyItem;
import servicedesk.tree.app.TreeBuilder;

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
	public void setItemClassDao(ItemClassDao dao) {
            registerDataSource("itemclass_cmdb", dao);
	}

        @Autowired
	public void setUniversalItemClassDao(UniversalItemClassDao dao) {
            registerDataSource("universalitemclass_cmdb", dao);
	}

        @Autowired
	public void setRelationshipClassDao(RelationshipClassDao dao) {
            registerDataSource("relationshipclass_cmdb", dao);
	}
	
	public HierarchyDao<?, ?> getDataSource(String dataSourceName) {
		return this.dataSources.get(dataSourceName);
	}
	
	@RequestMapping(value="/servicedesk/treePicker", method = RequestMethod.GET)
	public String showView(ModelMap model, @RequestParam("source") String dataSourceName, @RequestParam("name") String name, @RequestParam("value") String value) {
		model.addAttribute("source", dataSourceName);
		model.addAttribute("name", name);
		model.addAttribute("roots", TreeBuilder.buildTree(getDataSource(dataSourceName).getAll(), value));
		return "servicedesk/treePicker";
	}
	
	@RequestMapping(value="/servicedesk/treePickerChoose", method = RequestMethod.GET)
	public String onChoose(ModelMap model, @RequestParam("id") String itemId, @ModelAttribute("source") String dataSourceName) {

            HierarchicalDomainObject<?> item = NullHierarchyItem.INSTANCE;

            if(!itemId.equals("null")) {

                HierarchyDao<?, ?> dao = getDataSource(dataSourceName);
                Class<? extends Serializable> targetClass = dao.getIdClass();
                item = omg(targetClass, dao, itemId);
            }

            model.addAttribute("item", item);
            return "servicedesk/treePickerChoose";
	}

        private <Id extends Serializable> HierarchicalDomainObject<Id>
                omg(Class<Id> clazz, HierarchyDao<?, ?> dao, String itemId) {
            HierarchyDao<?, Id> typedDao = (HierarchyDao<?, Id>)dao;
            return typedDao.get(conversionService.convert(itemId, clazz));
        }
}
