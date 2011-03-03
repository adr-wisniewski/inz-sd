/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import sd.cmdb.domain.EntityClass;
import sd.cmdb.service.AttributeService;
import sd.cmdb.service.EntityClassService;
import sd.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public class AttributeController {

    public static final String PATH_CLASS = "classid";
    public static final String PATH_ATTR = "attrno";

    @Autowired
    protected AttributeService service;

    @Autowired
    protected EntityClassService entityClassService;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("attribute")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("Id");
        dataBinder.setDisallowedFields("Version");
        dataBinder.setDisallowedFields("EntityClass");
    }
}
