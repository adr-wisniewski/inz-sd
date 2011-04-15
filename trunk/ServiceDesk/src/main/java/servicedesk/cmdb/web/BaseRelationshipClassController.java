/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.RelationshipClassService;
import servicedesk.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
abstract public class BaseRelationshipClassController {
    @Autowired
    protected RelationshipClassService service;

    @Autowired
    protected MessageContextHolder messages;
}
