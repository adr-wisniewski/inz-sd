/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import servicedesk.core.itil.cmdb.domain.Attribute;
import servicedesk.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrno}/edit")
@PreAuthorize("hasRole('CMDB_ATTRIBUTE_EDIT')")
@SessionAttributes("attribute")
public class AttributeEditController extends AbstractAttributeController {
    public static final String VIEW_EDIT = "/cmdb/class/attribute/edit";

    @ModelAttribute
    public Attribute getAttribute(@PathVariable(PATH_ATTR) Integer attrNo) {
        return service.load(attrNo);
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet() {
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute Attribute attribute,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            service.update(attribute, bindingResult);
            messages.addMessage("message.cmdb.class.attribute.edited",
                    attribute.getName(),
                    attribute.getEntityClass().getName());
            status.setComplete();

            return redirectorVisitor.process(attribute.getEntityClass());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/class/%d/attribute/%d/edit",
                    attribute.getEntityClass().getId(),
                    attribute.getId());
        }
    }
}
