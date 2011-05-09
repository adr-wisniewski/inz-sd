/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.RelationshipClassService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

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
