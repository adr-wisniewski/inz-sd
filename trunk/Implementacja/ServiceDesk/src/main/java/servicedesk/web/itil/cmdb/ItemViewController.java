/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.cmdb.domain.EmployeeItem;
import servicedesk.core.itil.cmdb.domain.IncidentItem;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ProblemItem;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.core.itil.cmdb.domain.RfcItem;
import servicedesk.core.itil.cmdb.domain.ServiceItem;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;
import servicedesk.core.itil.cmdb.service.RelationshipService;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CMDB_ITEM_VIEW')")
public class ItemViewController extends AbstractItemController {

    @Autowired
    protected RelationshipService relationshipService;
    
    protected static final String MODEL_RELATIONSHIPS = "relationships";
    protected static final String MODEL_DETAILVIEW = "detailView";
    protected static final String VIEW_GENERAL = "/cmdb/item/view/general";
    protected static final String VIEW_DETAILS = "/cmdb/item/view/details";

    @RequestMapping(value = "/cmdb/item")
    public String general() {
        return VIEW_GENERAL;
    }

    @RequestMapping(value = "/cmdb/item/{id}")
    public String details(ModelMap map, @PathVariable(value="id") Integer id) {
        Item item = service.load(id);

        String detailView = DetailViewItemVisitor.process(item);
        if(detailView != null) {
            map.addAttribute(MODEL_DETAILVIEW, detailView);
        }
        
        List<Relationship> relationships = relationshipService.forItem(item);

      
        map.addAttribute(item);
        map.addAttribute(MODEL_RELATIONSHIPS, relationships);
        return VIEW_DETAILS;
    }

    protected static class DetailViewItemVisitor implements ItemVisitor {
        protected String redirectUrl;

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public static String process(Item item) {
            DetailViewItemVisitor visitor = new DetailViewItemVisitor();
            item.accept(visitor);
            return visitor.getRedirectUrl();
        }

        @Override
        public void visit(UniversalItem universalItem) {
            redirectUrl = null;
        }

        @Override
        public void visit(ServiceItem serviceItem) {
            redirectUrl = String.format("/scm/serviceDetails?id=%d", serviceItem.getService().getId());
        }

        @Override
        public void visit(RfcItem rfcItem) {
            redirectUrl = String.format("/cm/rfc/%d", rfcItem.getRfc().getId());
        }

        @Override
        public void visit(ProblemItem problemItem) {
            redirectUrl = String.format("/pm/edit?id=%d", problemItem.getProblem().getId());
        }

        @Override
        public void visit(IncidentItem incidentItem) {
            redirectUrl = String.format("/im/edit?id=%d", incidentItem.getIncident().getId());
        }

        @Override
        public void visit(EmployeeItem employeeItem) {
            redirectUrl = String.format("/servicedesk/employeeDetails?id=%d", employeeItem.getEmployee().getId());
        }
    }
}
