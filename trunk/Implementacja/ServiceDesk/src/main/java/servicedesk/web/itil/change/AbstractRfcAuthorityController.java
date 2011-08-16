/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.core.itil.change.service.RfcAuthorityService;
import servicedesk.web.spring.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public class AbstractRfcAuthorityController {
    @Autowired
    protected RfcAuthorityService service;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("rfcAuthority")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
