/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.UniversalItemService;
import sd.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
class UniversalItemController {
    @Autowired
    protected UniversalItemService service;

    @Autowired
    protected MessageContextHolder messages;
}
