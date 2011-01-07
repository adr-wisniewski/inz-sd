/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.spring.IllegalIdException;
import sd.spring.IllegalValueException;

/**
 *
 * @author Adrian
 */
public class ItemClassEditor extends PropertyEditorSupport
{
    ItemClassDao itemClassDao;

    public ItemClassEditor(ItemClassDao itemClassDao) {
        super();
        this.itemClassDao = itemClassDao;
    }

    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            ItemClass itemClass = itemClassDao.getById(Integer.parseInt(text));

            if(itemClass == null)
                throw new IllegalIdException(text);

            setValue(itemClass);
        }
        else
        {
            setValue(null);
        }
    }
}
