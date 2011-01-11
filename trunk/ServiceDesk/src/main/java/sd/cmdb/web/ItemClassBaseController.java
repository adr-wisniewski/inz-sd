/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.ClassAttributeService;
import sd.cmdb.service.ItemClassCrudService;
import sd.cmdb.service.ItemClassService;
import sd.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */

public class ItemClassBaseController
{
    @Autowired
    protected ItemClassCrudService itemClassCrudService;

    @Autowired
    protected ClassAttributeService classAttributeCrudService;

    @Autowired
    protected ItemClassService itemClassService;

    @Autowired
    protected MessageContextHolder messageStorage;
}
