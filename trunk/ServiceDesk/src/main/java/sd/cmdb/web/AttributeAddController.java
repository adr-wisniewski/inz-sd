/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

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
import sd.cmdb.domain.Attribute;
import sd.cmdb.domain.EntityClass;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/*")
@PreAuthorize("hasRole('CN_ATR_ADD')")
@SessionAttributes("attribute")
public class AttributeAddController extends AttributeController {
    public static final String VIEW_ADD = "/cmdb/class/attribute/add";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map, @PathVariable(PATH_CLASS) Integer classid) {

        EntityClass entityClass = entityClassService.load(classid);

        Attribute attribute = new Attribute();
        attribute.setEntityClass(entityClass);
        map.addAttribute(attribute);
        return String.format("redirect:/cmdb/class/%d/attribute/new", attribute.getEntityClass().getId());
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map,
            @ModelAttribute Attribute attribute,
            @PathVariable(PATH_CLASS) Integer classid) {

        EntityClass entityClass = entityClassService.load(classid);
        attribute.setEntityClass(entityClass);
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @PathVariable(PATH_CLASS) Integer classid,
            @ModelAttribute Attribute attribute,
            BindingResult bindingResult,
            SessionStatus status) {

        EntityClass entityClass = entityClassService.load(classid);
        attribute.setEntityClass(entityClass);

        try {
            service.add(attribute, bindingResult);
            messages.addMessage("message.cmdb.class.attribute.added",
                attribute.getName(),
                attribute.getEntityClass().getName());
            status.setComplete();

            return EntityClassRedirectorVisitor.process(entityClass);
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/class/%d/attribute/new",
                    attribute.getEntityClass().getId());
        }
    }
}
