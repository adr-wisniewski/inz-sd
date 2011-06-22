/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.itil.cmdb.service.ItemService;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.core.itil.cmdb.service.RelationshipService;
import servicedesk.web.spring.MessageContextHolder;

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
