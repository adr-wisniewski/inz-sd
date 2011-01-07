/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.service.ClassServiceFacade;
import sd.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */

public class BaseController
{
    @Autowired
    protected ClassServiceFacade classService;

    @Autowired
    protected MessageContextHolder messageStorage;
}
