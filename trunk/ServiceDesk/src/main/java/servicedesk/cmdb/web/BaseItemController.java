/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.ItemClassService;
import servicedesk.cmdb.service.ItemService;
import servicedesk.cmdb.service.RelationshipClassService;
import servicedesk.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class BaseItemController {
    @Autowired
    protected ItemService service;

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected RelationshipClassService relationshipClassService;

    @Autowired
    protected MessageContextHolder messages;
}
