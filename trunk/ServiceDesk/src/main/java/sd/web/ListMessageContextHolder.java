/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.web;

import java.util.LinkedList;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrian
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ListMessageContextHolder implements MessageContextHolder {

    transient private MessageSource messageSource;

    private List<String> messages = new LinkedList<String>();

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @Override
    public void addMessage(String code, Object... arguments)
    {
        String message = messageSource.getMessage(code, arguments, LocaleContextHolder.getLocale());
        messages.add(message);
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
