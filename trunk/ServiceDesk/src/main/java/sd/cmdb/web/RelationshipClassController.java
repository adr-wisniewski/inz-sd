/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.RelationshipClassService;
import sd.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public class RelationshipClassController {
    @Autowired
    protected RelationshipClassService service;

    @Autowired
    protected MessageContextHolder messages;
}
