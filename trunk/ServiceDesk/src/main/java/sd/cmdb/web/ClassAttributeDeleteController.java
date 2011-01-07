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
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ElementClass;
import sd.cmdb.validator.ClassAttributeDeleteableValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrid}/delete")
@PreAuthorize("hasRole('CN_ATR_DEL')")
public class ClassAttributeDeleteController extends BaseController {
    public static final String MODEL_ELEMENTCLASS = "elementClass";
    public static final String MODEL_ATTRIBUTE = "attribute";
    public static final String PATH_CLASS = "classid";
    public static final String PATH_ATTR = "attrid";
    public static final String VIEW_DELETE = "/cmdb/class/attribute/delete";

    @Autowired
    private ClassAttributeDeleteableValidator classAttributeDeleteableValidator;

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map,
            @PathVariable(PATH_CLASS) ElementClass elementClass,
            @PathVariable(PATH_ATTR) ClassAttribute classAttribute) {
        map.addAttribute(MODEL_ELEMENTCLASS, elementClass);
        map.addAttribute(MODEL_ATTRIBUTE, classAttribute);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @PathVariable(PATH_CLASS) ElementClass elementClass,
            @PathVariable(PATH_ATTR) ClassAttribute classAttribute,
            @RequestParam("submit") String submit)
    {
        if(!submit.equals("ok"))
            return String.format( "redirect:/cmdb/class/%d", elementClass.getIdentifier());

        DataBinder binder = new DataBinder(elementClass, "target");
        binder.setValidator(classAttributeDeleteableValidator);
        binder.validate();
        BindingResult results = binder.getBindingResult();

        if(results.hasErrors())
        {
            map.addAttribute(MODEL_ELEMENTCLASS, elementClass);
            map.addAttribute(MODEL_ATTRIBUTE, classAttribute);
            map.addAllAttributes(results.getModel());
            return String.format("prg:/cmdb/class/%d/attribute/%d/delete",
                    classAttribute.getId().getClassId(),
                    classAttribute.getId().getAttributeNo());
        }

        classService.deleteClassAttribute(classAttribute);
        messageStorage.addMessage("cmdb.message.class.attribute.deleted",
                classAttribute.getName(),
                elementClass.getName());
        
        return String.format("redirect:/cmdb/class/%d", elementClass.getIdentifier());
    }
}
