/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public class EnumOrdinalEditor<Type extends Enum<?>> extends PropertyEditorSupport {
    
    private final Class<Type> type;
    
    public EnumOrdinalEditor(Class<Type> type) {
        this.type = type;
    }
    
    @Override
    public void setAsText(String text) {  
        
        if(!StringUtils.hasText(text)) {
            setValue(null);
            return;
        }
           
        Integer ordinal = Integer.valueOf(text);

        for(Type state: type.getEnumConstants())
            if(state.ordinal() == ordinal) {
                setValue(state);
                return;
            }

        throw new IllegalArgumentException("Invalid ordinal " + ordinal);
    }
}
