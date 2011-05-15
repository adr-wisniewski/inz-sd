/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/*")
public class RfcController extends AbstractRfcController {
    
    static protected final String VIEW_BROWSE = "/change/rfc/browse";
    static protected final String VIEW_MANAGE = "/change/rfc/manage";
    static protected final String VIEW_ADMINISTER = "/change/rfc/administer";
    
    @RequestMapping(value = "/browse")
    public String browse() {
        return VIEW_BROWSE;
    }
    
    @RequestMapping(value = "/manage")
    public String manage() {
        return VIEW_MANAGE;
    }
    
    @RequestMapping(value = "/administer")
    public String administer() {
        return VIEW_ADMINISTER;
    }
}
