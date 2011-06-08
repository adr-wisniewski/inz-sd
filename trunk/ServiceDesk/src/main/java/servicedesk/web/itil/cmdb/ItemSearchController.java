/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import javax.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.cmdb.domain.EmployeeItemClass;
import servicedesk.core.itil.cmdb.domain.IncidentItemClass;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.ProblemItemClass;
import servicedesk.core.itil.cmdb.domain.RfcItemClass;
import servicedesk.core.itil.cmdb.domain.ServiceItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CMDB_ITEM_VIEW')")
public class ItemSearchController extends AbstractItemController {

    protected static final String PATH_CLASSID = "classid";
    protected static final String MODEL_READONLY = "readOnly";
    protected static final String MODEL_ITEMCLASS = "itemClass";
    protected static final String MODEL_ITEMCLASSES = "itemClasses";
    protected static final String MODEL_CRITERIA = "criteria";
    protected static final String MODEL_ITEMS = "items";
    protected static final String VIEW_SEARCH = "/cmdb/item/search";
    protected static final String VIEW_BROWSE_TREE = "/cmdb/item/browse/tree";
    protected static final String VIEW_BROWSE_CATEGORY = "/cmdb/item/browse/category";

    @Resource(name = "cmdbItemClassTree")
    protected TreeBuilder<?> cmdbItemClassTree;
    
    @RequestMapping(value = "/cmdb/item/search")
    public String search(ModelMap map, @ModelAttribute(MODEL_CRITERIA) ItemCriteria criteria) {
        map.addAttribute(MODEL_ITEMS, service.search(criteria));
        return VIEW_SEARCH;
    }

    @RequestMapping(value = "/cmdb/item/browse")
    public String browse(ModelMap map) {
        map.addAttribute(MODEL_ITEMCLASSES, cmdbItemClassTree.buildTree());
        return VIEW_BROWSE_TREE;
    }

    @RequestMapping(value = "/cmdb/item/browse/{classid}")
    public String browseName(ModelMap map, @PathVariable(PATH_CLASSID) Integer id) {
        ItemClass itemClass = itemClassService.load(id);
        Iterable<Item> items = service.getByClass(itemClass);

        Boolean readOnly = IsReadOnlyItemClassVisitor.process(itemClass);
        map.addAttribute(MODEL_READONLY, readOnly);
        map.addAttribute(MODEL_ITEMCLASS, itemClass);
        map.addAttribute(MODEL_ITEMS, items);
        
        return VIEW_BROWSE_CATEGORY;
    }

    protected static class IsReadOnlyItemClassVisitor implements ItemClassVisitor {

        protected Boolean readOnly = true;

        public Boolean isReadOnly() {
            return readOnly;
        }

        public static Boolean process(ItemClass itemClass) {
            IsReadOnlyItemClassVisitor visitor = new IsReadOnlyItemClassVisitor();
            itemClass.accept(visitor);
            return visitor.isReadOnly();
        }

        @Override
        public void visit(UniversalItemClass universalItemClass) {
            readOnly = false;
        }

        @Override
        public void visit(EmployeeItemClass employeeItemClass) {
            // default
        }

        @Override
        public void visit(IncidentItemClass incidentItemClass) {
            // default
        }

        @Override
        public void visit(ProblemItemClass problemItemClass) {
            // default
        }

        @Override
        public void visit(RfcItemClass rfcItemClass) {
            // default
        }

        @Override
        public void visit(ServiceItemClass serviceItemClass) {
            // default
        }

    }
}
