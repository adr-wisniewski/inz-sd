/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/authority")
public class RfcAuthorityViewController extends AbstractRfcAuthorityController {
    
    protected static final String VIEW_ALL = "/change/rfc/authority";
    protected static final String VIEW_SINGLE = "/change/rfc/authority/view";
    protected static final String MODEL_AUTHORITY = "authority";
    protected static final String MODEL_AUTHORITIES = "authorities";
    
    @RequestMapping
    public String all(ModelMap map) {
        List<RfcAuthority> all = service.getAll();
        map.addAttribute(MODEL_AUTHORITIES, all);
        return VIEW_ALL;
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcAuthority authority = service.load(id);
        map.addAttribute(MODEL_AUTHORITY, authority);
        return VIEW_SINGLE;
    }
}
