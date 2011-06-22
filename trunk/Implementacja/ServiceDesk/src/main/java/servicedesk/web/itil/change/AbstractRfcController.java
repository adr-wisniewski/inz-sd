/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.core.itil.change.service.RfcCategoryService;
import servicedesk.core.itil.change.service.RfcImpactService;
import servicedesk.core.itil.change.service.RfcPriorityService;
import servicedesk.core.itil.change.service.RfcResolutionService;
import servicedesk.core.itil.change.service.RfcService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public class AbstractRfcController {
    @Autowired
    protected RfcService service;
       
    @Autowired
    protected RfcPriorityService priorityService;
    
    @Autowired
    protected RfcImpactService impactService;
    
    @Autowired
    protected RfcResolutionService resolutionService;
    
    @Autowired
    protected RfcCategoryService categoryService;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("rfc")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("author");
        dataBinder.setDisallowedFields("creationDate");
    }
}
