/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.itil.cmdb.service.UniversalItemClassService;
import servicedesk.web.spring.MessageContextHolder;

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
