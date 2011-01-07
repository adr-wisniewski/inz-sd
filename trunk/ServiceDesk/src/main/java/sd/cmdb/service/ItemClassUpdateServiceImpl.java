/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassEditableValidator;
import sd.validation.ValidationUtils;

/**
 *
 * @author Adrian
 */
public class ItemClassUpdateServiceImpl implements ItemClassUpdateService {

    @Autowired
    private ItemClassDao itemClassDao;
    
    @Autowired
    private ItemClassLoadService itemClassLoadService;

    @Override
    public void update(ItemClass itemClass) {
        ItemClass sameNameClass = itemClassLoadService.getByName(itemClass.getName());
        ItemClassEditableValidator validator = new ItemClassEditableValidator(sameNameClass);
        ValidationUtils.validate(itemClass, "itemClass", validator);
        itemClassDao.update(itemClass);
    }
}
