/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import servicedesk.core.itil.change.domain.RfcState;

/**
 *
 * @author Adrian
 */
@Component
public class RfcStateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)) {
            Integer ordinal = Integer.valueOf(text);
            RfcState state = RfcState.get(ordinal);
            setValue(state);
        }
    }
    
}
