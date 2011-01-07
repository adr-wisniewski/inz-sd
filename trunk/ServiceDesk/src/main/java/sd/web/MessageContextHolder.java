/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.web;

import java.io.Serializable;
import java.util.List;
import org.springframework.context.MessageSourceAware;

/**
 *
 * @author Adrian
 */
public interface MessageContextHolder extends Serializable, MessageSourceAware {
    public void addMessage(String code, Object... arguments);
    public List<String> getMessages();
}
