/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.ItemClassService;
import sd.cmdb.service.ItemService;
import sd.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public class ItemController {
    @Autowired
    protected ItemService service;

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected MessageContextHolder messages;
}
