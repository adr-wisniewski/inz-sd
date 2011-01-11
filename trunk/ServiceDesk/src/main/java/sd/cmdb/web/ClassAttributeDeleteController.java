/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

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
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributeId;
import sd.infrastructure.validation.BusinessConstraintViolationException;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrno}/delete")
@PreAuthorize("hasRole('CN_ATR_DEL')")
@SessionAttributes(types=ClassAttribute.class)
public class ClassAttributeDeleteController extends ItemClassBaseController {
    public static final String PATH_CLASS = "classid";
    public static final String PATH_ATTR = "attrno";
    public static final String VIEW_DELETE = "/cmdb/class/attribute/delete";

    @RequestMapping(method=RequestMethod.GET)
    public String deleteGet(ModelMap map,
            @PathVariable(PATH_CLASS) Integer classId,
            @PathVariable(PATH_ATTR) Integer attrNo) {

        ClassAttributeId classAttributeId = new ClassAttributeId(classId, attrNo);
        ClassAttribute classAttribute = classAttributeCrudService.load(classAttributeId);

        map.addAttribute(classAttribute);
        return VIEW_DELETE;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String deletePost(
            ModelMap map,
            @RequestParam("submit") String submit,
            @ModelAttribute ClassAttribute classAttribute,
            SessionStatus status)
    {

        String viewName;

        try {
            if(submit.equals("ok")) {
                classAttributeCrudService.delete(classAttribute);
                messageStorage.addMessage("cmdb.message.class.attribute.deleted",
                classAttribute.getName(),
                classAttribute.getElementClass().getName());

                viewName = String.format("redirect:/cmdb/class/%d",
                        classAttribute.getId().getClassId());
            }
            else {
                viewName =  String.format( "redirect:/cmdb/class/%d",
                        classAttribute.getId().getClassId());
            }

            status.setComplete();
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            viewName = String.format("prg:/cmdb/class/%d/attribute/%d/delete",
                classAttribute.getId().getClassId(),
                classAttribute.getId().getAttributeNo());
        }

        return viewName;
    }
}
