/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.spring;

import servicedesk.infrastructure.general.web.MessageContextHolder;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian
 */
public class MessageInterceptor implements HandlerInterceptor {

    private final static String MODEL_KEY = "messages";
    private final static String REQUEST_KEY = "servicedesk.web.MessageInterceptor.messages";

    @Autowired
    private MessageContextHolder messageStorage;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // retrive and delete messages from session and
        List<String> messages = new LinkedList<String>(messageStorage.getMessages());
        messageStorage.getMessages().clear();
        
        request.setAttribute(REQUEST_KEY, messages);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // add previously retrived messages to modelmap
        List<String> messages = (List<String>) request.getAttribute(REQUEST_KEY);
        modelAndView.addObject(MODEL_KEY, messages);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }

}
