/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.cmdb.domain.EmployeeItem;
import servicedesk.cmdb.domain.IncidentItem;
import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ProblemItem;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.RfcItem;
import servicedesk.cmdb.domain.ServiceItem;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@Controller
@PreAuthorize("hasRole('CMDB_ITEM_VIEW')")
public class ItemViewController extends BaseItemController {

    protected static final String MODEL_SOURCE_RELATIONSHIPCLASSES = "sourceRelationships";
    protected static final String MODEL_TARGET_RELATIONSHIPCLASSES = "targetRelationships";
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

        List<RelationshipClass> sourceRelationshipClasses = relationshipClassService.getAllForSourceClass(item.getItemClass());
        List<RelationshipClass> targetRelationshipClasses = relationshipClassService.getAllForTargetClass(item.getItemClass());

        map.addAttribute(item);
        map.addAttribute(MODEL_SOURCE_RELATIONSHIPCLASSES, sourceRelationshipClasses);
        map.addAttribute(MODEL_TARGET_RELATIONSHIPCLASSES, targetRelationshipClasses);
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
