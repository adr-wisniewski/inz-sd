/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassValidator;
import sd.validation.ValidationUtils;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class ItemClassAddServiceImpl implements ItemClassAddService {

    @Autowired
    private ItemClassDao itemClassDao;

    @Autowired
    private ItemClassLoadService itemClassLoadService;

    @Override
    public void addItemClass(ItemClass itemClass) {
        ItemClass sameNameClass = itemClassLoadService.getByName(itemClass.getName());
        ItemClassValidator validator = new ItemClassValidator(sameNameClass);
        ValidationUtils.validate(itemClass, "itemClass", validator);
        itemClassDao.save(itemClass);
    }

}
