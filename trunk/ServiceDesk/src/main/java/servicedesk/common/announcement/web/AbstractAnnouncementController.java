/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import servicedesk.common.announcement.service.AnnouncementService;
import servicedesk.infrastructure.general.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AbstractAnnouncementController {
    @Autowired
    protected AnnouncementService service;

    @Autowired
    protected MessageContextHolder messages;

    @InitBinder("announcement")
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("author");

        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy HH:mm"), true);
        dataBinder.registerCustomEditor(Date.class, editor);
    }
}
