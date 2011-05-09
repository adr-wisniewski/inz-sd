/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.cmdb.domain.Attribute;
import servicedesk.infrastructure.general.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrno}/delete")
@PreAuthorize("hasRole('CMDB_ATTRIBUTE_DELETE')")
@SessionAttributes("attribute")
public class AttributeDeleteController extends AbstractAttributeController {
    public static final String VIEW_DELETE = "/cmdb/class/attribute/delete";

    @ModelAttribute
    public Attribute getAttribute(@PathVariable(PATH_ATTR) Integer attrNo) {
        return service.load(attrNo);
    }

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet() {
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @RequestParam("submit") String submit,
            @ModelAttribute Attribute attribute,
            SessionStatus status)
    {

        String viewName;

        try {
            if(submit.equals("ok")) {
                service.delete(attribute);
                messages.addMessage("message.cmdb.class.attribute.deleted",
                attribute.getName(),
                attribute.getEntityClass().getName());    
            }

            status.setComplete();
            viewName = EntityClassRedirectorVisitor.process(attribute.getEntityClass());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            viewName = String.format("prg:/cmdb/class/%d/attribute/%d/delete",
                attribute.getEntityClass().getId(),
                attribute.getId());
        }

        return viewName;
    }
}
