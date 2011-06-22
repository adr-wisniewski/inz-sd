/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
abstract public class AbstractRelationshipClassController {
    @Autowired
    protected RelationshipClassService service;

    @Autowired
    protected MessageContextHolder messages;
}
