/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import servicedesk.cmdb.domain.Item;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.service.ItemClassService;
import servicedesk.cmdb.service.ItemService;

/**
 *
 * @author Adrian
 */
@Component
public class ItemEditor extends PropertyEditorSupport {
    @Autowired
    ItemService service;

    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            Integer id = Integer.parseInt(text);
            Item item = service.load(id);
            setValue(item);
        }
        else
        {
            setValue(null);
        }
    }
}
