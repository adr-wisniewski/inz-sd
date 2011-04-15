/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.cmdb.service.AttributeService;
import servicedesk.cmdb.service.EntityClassService;
import servicedesk.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class BaseAttributeController {

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
