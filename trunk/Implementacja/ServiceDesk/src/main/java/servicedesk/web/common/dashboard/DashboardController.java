package servicedesk.web.common.dashboard;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.base.security.domain.ClientUser;
import servicedesk.core.base.security.domain.CooperantUser;
import servicedesk.core.base.security.domain.EmployeeUser;
import servicedesk.core.common.announcement.service.AnnouncementService;

import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.domain.UserVisitor;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.base.signal.service.SignalService;
import servicedesk.core.common.notification.service.NotificationService;

@Controller
public class DashboardController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private SignalService signalService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    protected AnnouncementService announcementService;
    
    protected DashboardPicker dashboardPicker = new DashboardPicker();

    @RequestMapping(value = "/servicedesk/dashboard")
    public String dashboard(ModelMap model) {
        User user = authorizationService.getCurrentUser();
        return user.accept(dashboardPicker, model);
    }

    protected class DashboardPicker implements UserVisitor<String, ModelMap> {

        @Override
        public String visit(ClientUser client, ModelMap context) {
            AddCommonDashboardAttributes(client, context);
            return "servicedesk/dashboard";
        }

        @Override
        public String visit(CooperantUser cooperant, ModelMap context) {
            AddCommonDashboardAttributes(cooperant, context);
            return "servicedesk/dashboard";
        }

        @Override
        public String visit(EmployeeUser employee, ModelMap context) {
            AddCommonDashboardAttributes(employee, context);
            context.addAttribute("signals", signalService.getSignalsForEmployee(employee.getEmployee()));
            return "servicedesk/dashboard";
        }

        protected void AddCommonDashboardAttributes(User user, ModelMap model) {
            model.addAttribute("announcements", announcementService.getUpToDate(new Date()));
            model.addAttribute("notifications", notificationService.getForUser(user));
        }
    }
}
