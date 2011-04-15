/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.cmdb.service.UniversalItemClassService;
import servicedesk.cmdb.service.UniversalItemService;
import servicedesk.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
abstract class BaseUniversalItemController {
    @Autowired
    protected UniversalItemService service;

    @Autowired
    protected UniversalItemClassService universalItemClassService;

    @Autowired
    protected MessageContextHolder messages;
}
