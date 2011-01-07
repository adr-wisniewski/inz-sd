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
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributePk;
import sd.cmdb.domain.ElementClass;
import sd.cmdb.validator.ClassAttributeValidator;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/cmdb/class/{classid}/attribute/{attrid}/edit")
@PreAuthorize("hasRole('CN_ATR_EDI')")
public class ClassAttributeEditController extends BaseController {
    public static final String MODEL_ELEMENTCLASS = "elementClass";
    public static final String MODEL_ATTRIBUTE = "attribute";
    public static final String PATH_CLASS = "classid";
    public static final String PATH_ATTR = "attrid";
    public static final String VIEW_EDIT = "/cmdb/class/attribute/edit";
    
    @Autowired
    private ClassAttributeValidator classAttributeValidator;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("classId");
        dataBinder.setDisallowedFields("AttributeNo");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String editGet(ModelMap map, 
            @PathVariable(PATH_CLASS) Integer classId,
            @PathVariable(PATH_ATTR) Integer attrNo) {

        ElementClass elementClass = classService.loadElementClass(classId);

        ClassAttributePk classAttributePk = new ClassAttributePk(classId, attrNo);
        ClassAttribute classAttribute = classService.loadClassAttribute(classAttributePk);

        map.addAttribute(MODEL_ELEMENTCLASS, elementClass);
        map.addAttribute(MODEL_ATTRIBUTE, classAttribute);
        return VIEW_EDIT;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String editPost(@PathVariable(PATH_CLASS) ElementClass elementClass,
            @PathVariable(PATH_ATTR) Integer attributeNo,
            @ModelAttribute(MODEL_ATTRIBUTE) ClassAttribute classAttribute,
            BindingResult bindingResult) {

        // fill in primary key and validate
        classAttribute.getId().setClassId(elementClass.getIdentifier());
        classAttribute.getId().setAttributeNo(attributeNo);
        classAttributeValidator.validate(classAttribute, bindingResult);

        // redirect on errors
        if(bindingResult.hasErrors())
            return String.format("prg:/cmdb/class/%d/attribute/%d/edit", 
                    classAttribute.getId().getClassId(),
                    classAttribute.getId().getAttributeNo());

        classService.updateClassAttribute(classAttribute);
        messageStorage.addMessage("cmdb.message.class.attribute.edited", 
                classAttribute.getName(),
                elementClass.getName());
        return String.format("redirect:/cmdb/class/%d", elementClass.getIdentifier());
    }
}
