/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
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
import sd.cmdb.domain.ElementClass;
import sd.cmdb.validator.ClassAttributeValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/*")
@PreAuthorize("hasRole('CN_ATR_ADD')")
@SessionAttributes(ClassAttributeAddController.MODEL_ATTRIBUTE)
public class ClassAttributeAddController extends BaseController {
    public static final String MODEL_ATTRIBUTE = "attribute";
    public static final String MODEL_ELEMENTCLASS = "elementClass";
    public static final String PATH_CLASS = "classid";
    public static final String VIEW_ADD = "/cmdb/class/attribute/add";

    @Autowired
    private ClassAttributeValidator classAttributeValidator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("classId");
        dataBinder.setDisallowedFields("AttributeNo");
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String creteNewInstance(ModelMap map, @PathVariable(PATH_CLASS) ElementClass elementClass) {
            map.addAttribute(MODEL_ATTRIBUTE, new ClassAttribute());
            map.addAttribute(MODEL_ELEMENTCLASS, elementClass);
            return String.format("redirect:/cmdb/class/%d/attribute/new", elementClass.getIdentifier());
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String showNewInstance(ModelMap map, @ModelAttribute(MODEL_ATTRIBUTE) ClassAttribute classAttribute, @PathVariable(PATH_CLASS) ElementClass elementClass) {
        map.addAttribute(MODEL_ELEMENTCLASS, elementClass);
        return VIEW_ADD;
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String saveNewInstance(
            @ModelAttribute(MODEL_ATTRIBUTE) ClassAttribute classAttribute,
            BindingResult bindingResult,
            @PathVariable(PATH_CLASS) ElementClass elementClass,
            SessionStatus status) {

        classAttribute.getId().setClassId(elementClass.getIdentifier());

        classAttributeValidator.validate(classAttribute, bindingResult);
        if(bindingResult.hasErrors())
            return String.format("redirect:/cmdb/class/%d/attribute/new",
                    elementClass.getIdentifier());

        classService.addClassAttribute(classAttribute);
        messageStorage.addMessage("cmdb.message.class.attribute.added", 
                classAttribute.getName(),
                elementClass.getName());
        
        status.setComplete();
        return String.format("redirect:/cmdb/class/%d", elementClass.getIdentifier());
    }
}
