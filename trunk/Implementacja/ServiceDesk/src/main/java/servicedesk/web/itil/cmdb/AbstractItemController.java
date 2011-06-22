/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.itil.cmdb.service.ItemClassService;
import servicedesk.core.itil.cmdb.service.ItemService;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractItemController {
    @Autowired
    protected ItemService service;

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected RelationshipClassService relationshipClassService;

    @Autowired
    protected MessageContextHolder messages;
}
