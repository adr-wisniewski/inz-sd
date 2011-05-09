/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.UniversalItemClassService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractItemClassController {
    
    @Autowired
    protected UniversalItemClassService service;

    @Autowired
    protected MessageContextHolder messages;
}
