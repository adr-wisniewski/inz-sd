/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.itil.cmdb.service.UniversalItemClassService;
import servicedesk.core.itil.cmdb.service.UniversalItemService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractUniversalItemController {
    
    public static final String MODEL_OBJECT = "universalItem";
    
    @Autowired
    protected UniversalItemService service;

    @Autowired
    protected UniversalItemClassService universalItemClassService;

    @Autowired
    protected MessageContextHolder messages;
}
