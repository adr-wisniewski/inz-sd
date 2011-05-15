/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicedesk.change.domain.RfcResolution;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/change/rfc/resolution")
public class RfcResolutionViewController extends AbstractRfcResolutionController {
    
    protected static final String VIEW_LIST = "/change/rfc/resolution";
    protected static final String VIEW_VIEW = "/change/rfc/resolution/view";
    protected static final String MODEL_RESOLUTIONS = "resolutions";
    
    @RequestMapping
    public String list(ModelMap map) {
        List<RfcResolution> resolutions = service.getAll();
        map.addAttribute(MODEL_RESOLUTIONS, resolutions);
        return VIEW_LIST;
    }
    
    @RequestMapping(value = "/{id}")
    public String view(ModelMap map, @PathVariable("id") Integer id) {
        RfcResolution resolution = service.load(id);
        map.addAttribute(resolution);
        return VIEW_VIEW;
    }
}
