/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.common.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import servicedesk.core.itil.change.domain.entity.RfcNotification;

/**
 *
 * @author Adrian
 */
@Component
public class NotificationTextResolver implements RfcNotification.Visitor<String, String> {

    protected String t(String code, RfcNotification visited) {
        return _t(code, visited.getRfc().getId(), visited.getRfc().getTitle());
    }
    
    protected String _t(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }  
    
    @Autowired
    protected MessageSource messageSource;
    
    @Override
    public String visitRfcUpdated(String context, RfcNotification visited) {
        return t("notification.change.rfc.updated", visited);
    }

    @Override
    public String visitRfcAddedComment(String context, RfcNotification visited) {
        return t("notification.change.rfc.addedComment", visited);
    }

    @Override
    public String visitRfcAssigned(String context, RfcNotification visited) {
        return t("notification.change.rfc.assigned", visited);
    }

    @Override
    public String visitRfcUnassigned(String context, RfcNotification visited) {
        return t("notification.change.rfc.unassigned", visited);
    }

    @Override
    public String visitRfcReviewed(String context, RfcNotification visited) {
        return t("notification.change.rfc.reviewed", visited);
    }

    @Override
    public String visitRfcAppealed(String context, RfcNotification visited) {
        return t("notification.change.rfc.appealed", visited);
    }

    @Override
    public String visitRfcReopened(String context, RfcNotification visited) {
        return t("notification.change.rfc.reopened", visited);
    }

    @Override
    public String visitRfcRejected(String context, RfcNotification visited) {
        return t("notification.change.rfc.rejected", visited);
    }

    @Override
    public String visitRfcClosed(String context, RfcNotification visited) {
        return t("notification.change.rfc.closed", visited);
    }

    @Override
    public String visitRfcBuilt(String context, RfcNotification visited) {
        return t("notification.change.rfc.built", visited);
    }

    @Override
    public String visitRfcScheduled(String context, RfcNotification visited) {
        return t("notification.change.rfc.scheduled", visited);
    }

    @Override
    public String visitRfcAuthorized(String context, RfcNotification visited) {
        return t("notification.change.rfc.authorized", visited);
    }

    @Override
    public String visitRfcAssessed(String context, RfcNotification visited) {
        return t("notification.change.rfc.assessed", visited);
    }
    
     
}
