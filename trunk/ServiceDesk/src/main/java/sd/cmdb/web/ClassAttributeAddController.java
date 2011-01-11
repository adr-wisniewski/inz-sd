/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributeId;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/*")
@PreAuthorize("hasRole('CN_ATR_ADD')")
@SessionAttributes(types=ClassAttribute.class)
public class ClassAttributeAddController extends ItemClassBaseController {
    public static final String PATH_CLASS = "classid";
    public static final String VIEW_ADD = "/cmdb/class/attribute/add";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("classId");
        dataBinder.setDisallowedFields("AttributeNo");
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map, 
            @PathVariable(PATH_CLASS) Integer classid) {

        ClassAttributeId classAttributeId = new ClassAttributeId(classid, null);

        ClassAttribute classAttribute = new ClassAttribute();
        classAttribute.setId(classAttributeId);
        map.addAttribute(new ClassAttribute());

        return String.format("redirect:/cmdb/class/%d/attribute/new",
                classAttribute.getId().getClassId());
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, ClassAttribute classAttribute) {
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(ModelMap map,
            @ModelAttribute ClassAttribute classAttribute,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            classAttributeCrudService.add(classAttribute, bindingResult);
            messageStorage.addMessage("cmdb.message.class.attribute.added",
                classAttribute.getName(),
                classAttribute.getElementClass().getName());
            status.setComplete();

            return String.format("redirect:/cmdb/item/class/%d",
                    classAttribute.getElementClass().getId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());

            return String.format("prg:/cmdb/class/%d/attribute/new",
                    classAttribute.getElementClass().getId());
        }
    }
}
