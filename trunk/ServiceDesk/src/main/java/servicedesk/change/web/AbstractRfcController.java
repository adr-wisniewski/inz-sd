/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.change.service.RfcCategoryService;
import servicedesk.change.service.RfcImpactService;
import servicedesk.change.service.RfcPriorityService;
import servicedesk.change.service.RfcService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

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
