/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.ItemService;
import servicedesk.cmdb.service.RelationshipClassService;
import servicedesk.cmdb.service.RelationshipService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRelationshipController {
    @Autowired
    protected RelationshipService relationshipService;

    @Autowired
    protected RelationshipClassService relationshipClassService;

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected MessageContextHolder messages;
}
