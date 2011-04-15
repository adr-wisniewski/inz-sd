/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.spring;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian
 */
public class PrgInterceptor implements HandlerInterceptor {

    private static final String PREFIX = "prg:";
    private static final String SESSION_MODEL_KEY = "servicedesk.web.PrgInterceptor.Model";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String viewName = modelAndView.getViewName();
        Map<String, ?> model =
                (Map<String, ?>)request.getSession().getAttribute(SESSION_MODEL_KEY);

        // check for prg:<url> redirects
        if (viewName != null && viewName.startsWith(PREFIX)) {
            viewName = viewName.substring(PREFIX.length());

            // save model and redirect to given url
            request.getSession().setAttribute(SESSION_MODEL_KEY, modelAndView.getModel());
            modelAndView.setViewName("redirect:" + viewName);
        }
        // on next request restore model from session
        else if(model != null) {
            modelAndView.addAllObjects(model);
            request.getSession().removeAttribute(SESSION_MODEL_KEY);
        }
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }

}
