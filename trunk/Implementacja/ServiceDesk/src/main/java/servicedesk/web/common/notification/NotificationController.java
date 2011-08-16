/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.common.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicedesk.core.common.notification.domain.Notification;
import servicedesk.core.common.notification.service.NotificationService;
import servicedesk.core.itil.change.domain.entity.RfcNotification;

/**
 *
 * @author Adrian
 */
@Controller
public class NotificationController {
    
    @Autowired
    protected NotificationService notificationService;
    
    protected NotificationLinkResolver linkResolver = new NotificationLinkResolver();
    
    @RequestMapping(value="/common/notification/{id}/visit", method=RequestMethod.GET)
    public String visit(@PathVariable("id") Integer id) {
        Notification notification = notificationService.load(id);
        notification.setVisited(true);
        notificationService.update(notification);
        return String.format("redirect:%s", notification.accept(linkResolver, null));
    }
    
    @RequestMapping(value="/common/notification/{id}/delete", method=RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        Notification notification = notificationService.load(id);
        notificationService.delete(notification);
        return "redirect:/";
    }
    
    public static class NotificationLinkResolver implements RfcNotification.Visitor<String, String> {

        protected String rfcViewPage(RfcNotification visited) {
            return String.format("/change/rfc/%d", visited.getRfc().getId());
        }
        
        @Override
        public String visitRfcUpdated(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcAddedComment(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcAssigned(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcUnassigned(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcReviewed(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcAppealed(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcReopened(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcRejected(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcClosed(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcBuilt(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcScheduled(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcAuthorized(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

        @Override
        public String visitRfcAssessed(String context, RfcNotification visited) {
            return rfcViewPage(visited);
        }

    }
}
