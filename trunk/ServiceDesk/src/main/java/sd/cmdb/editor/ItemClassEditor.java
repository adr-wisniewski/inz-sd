/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.service.UniversalItemClassService;

/**
 *
 * @author Adrian
 */
@Component
public class ItemClassEditor extends PropertyEditorSupport
{
    @Autowired
    UniversalItemClassService service;

    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            Integer id = Integer.parseInt(text);
            UniversalItemClass itemClass = service.get(id);

            //TODO: error checking
            
            setValue(itemClass);
        }
        else
        {
            setValue(null);
        }
    }
}
