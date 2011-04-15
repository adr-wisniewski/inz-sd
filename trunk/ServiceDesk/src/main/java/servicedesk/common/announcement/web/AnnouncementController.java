/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.web;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.common.announcement.service.AnnouncementService;
import servicedesk.infrastructure.web.MessageContextHolder;

/**
 *
 * @author Adrian
 */
public abstract class AnnouncementController {
    @Autowired
    protected AnnouncementService service;

    @Autowired
    protected MessageContextHolder messages;
}
