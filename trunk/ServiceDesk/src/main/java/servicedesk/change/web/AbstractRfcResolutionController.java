/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.change.service.RfcResolutionService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractRfcResolutionController {
    @Autowired
    protected RfcResolutionService service;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("rfcResolution")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
