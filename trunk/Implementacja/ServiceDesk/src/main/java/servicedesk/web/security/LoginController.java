/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Adrian
 */
@Controller
public class LoginController {
    static private String LOGIN_VIEW = "login";
    
    @RequestMapping("/login")
    public String login() {
        return LOGIN_VIEW;
    }
}
