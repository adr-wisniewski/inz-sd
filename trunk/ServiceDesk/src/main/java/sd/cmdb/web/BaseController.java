/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.ClassService;
import sd.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */

public class BaseController
{
    @Autowired
    protected ClassService administrationService;

    @Autowired
    protected MessageContextHolder messageStorage;
}
