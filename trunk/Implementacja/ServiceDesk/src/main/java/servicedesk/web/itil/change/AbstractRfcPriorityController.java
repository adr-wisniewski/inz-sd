/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.core.itil.change.service.RfcPriorityService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcPriorityController {
    
    public static final String MODEL_OBJECT = "rfcPriority";
    
    @Autowired
    protected RfcPriorityService service;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("rfcPriority")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
