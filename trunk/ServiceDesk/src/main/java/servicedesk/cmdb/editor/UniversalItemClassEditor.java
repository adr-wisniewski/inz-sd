/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.service.UniversalItemClassService;

/**
 *
 * @author Adrian
 */
@Component
public class UniversalItemClassEditor extends PropertyEditorSupport
{
    @Autowired
    UniversalItemClassService service;

    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            Integer id = Integer.parseInt(text);
            UniversalItemClass itemClass = service.load(id);

            // TODO: get instead of load + error checking?

            setValue(itemClass);
        }
        else
        {
            setValue(null);
        }
    }
}
