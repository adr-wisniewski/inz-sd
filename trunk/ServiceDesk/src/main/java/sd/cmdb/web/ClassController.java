/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sd.cmdb.domain.ElementClass;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.RelationshipClass;

/**
 *
 * @author Adrian
 */
@Controller
public class ClassController {
    public static final String PATH_CLASS = "classid";

    /*@RequestMapping(value="/cmdb/class/{classid}", method = RequestMethod.GET)
    public String creteNewInstance(@PathVariable(PATH_CLASS) ElementClass elementClass) {
        if(elementClass instanceof ItemClass) {
            return String.format("redirect:/cmdb/item/class/%d", elementClass.getIdentifier());
        }
        else if(elementClass instanceof RelationshipClass) {
            return String.format("redirect:/cmdb/relationship/class/%d", elementClass.getIdentifier());
        }
        else {
            throw new IllegalArgumentException(String.format("Class %s is of unhandled type", elementClass.toString()));
        }
    }*/
}
