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
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrno}/edit")
@PreAuthorize("hasRole('CN_ATR_EDI')")
@SessionAttributes(types=ClassAttribute.class)
public class ClassAttributeEditController extends ItemClassBaseController {
    public static final String PATH_CLASS = "classid";
    public static final String PATH_ATTR = "attrno";
    public static final String VIEW_EDIT = "/cmdb/class/attribute/edit";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("classId");
        dataBinder.setDisallowedFields("AttributeNo");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, 
            @PathVariable(PATH_CLASS) Integer classId,
            @PathVariable(PATH_ATTR) Integer attrNo) {

        ClassAttributeId classAttributePk = new ClassAttributeId(classId, attrNo);
        ClassAttribute classAttribute = classAttributeCrudService.load(classAttributePk);

        map.addAttribute(classAttribute);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(ModelMap map,
            @ModelAttribute ClassAttribute classAttribute,
            BindingResult bindingResult,
            SessionStatus status) {

        try {
            classAttributeCrudService.update(classAttribute, bindingResult);
            messageStorage.addMessage("cmdb.message.class.attribute.edited",
                    classAttribute.getName(),
                    classAttribute.getElementClass().getName());
            status.setComplete();

            return String.format("redirect:/cmdb/class/%d", classAttribute.getId().getClassId());
        }
        catch(BusinessConstraintViolationException ex) {
            map.addAllAttributes(ex.getErrors().getModel());
            return String.format("prg:/cmdb/class/%d/attribute/%d/edit",
                    classAttribute.getId().getClassId(),
                    classAttribute.getId().getAttributeNo());
        }
    }
}
