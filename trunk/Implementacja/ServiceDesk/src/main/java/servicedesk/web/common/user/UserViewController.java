/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.common.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicedesk.core.base.security.domain.ClientUser;
import servicedesk.core.base.security.domain.CooperantUser;
import servicedesk.core.base.security.domain.EmployeeUser;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.domain.UserVisitor;
import servicedesk.core.base.security.service.UserService;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/user/*")
public class UserViewController {
    
    protected static final String VIEW_DETAILS = "/common/user/view";
    
    @Autowired
    private UserService service;
    
    private UserTypeResolver userTypeResolver = new UserTypeResolver();

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String details(ModelMap model, @PathVariable("id") Integer id) {
        User user = service.load(id);
        String userType = user.accept(userTypeResolver, 0);
            
        model.addAttribute("type", userType);
        model.addAttribute("user", user);
        return VIEW_DETAILS;
   }
    
    protected class UserTypeResolver implements UserVisitor<String, Integer> {

        @Override
        public String visit(ClientUser client, Integer context) {
            return "client";
        }

        @Override
        public String visit(CooperantUser cooperant, Integer context) {
            return "cooperant";
        }

        @Override
        public String visit(EmployeeUser employee, Integer context) {
            return "employee";
        }
    }
}
