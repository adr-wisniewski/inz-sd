/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemClassDeleteableValidator;
import sd.validation.ValidationUtils;

/**
 *
 * @author Adrian
 */
@Scope("prototype")
@Service
@Transactional(isolation=Isolation.REPEATABLE_READ)
public class ItemClassDeleteServiceImpl implements ItemClassDeleteService {

    @Autowired
    private ItemClassDao itemClassDao;

    @Autowired
    private ItemClassLoadService getItemClassService;

    protected ItemClass itemClass;

    @Override
    public void delete(Integer id) {
         itemClass = getItemClassService.load(id);
         delete(itemClass);
    }

    public void delete(ItemClass itemClass) {
        ValidationUtils.validate(itemClass, "itemClass", new ItemClassDeleteableValidator());
        itemClassDao.delete(itemClass);
    }

    @Override
    public ItemClass getItemClass() {
        return itemClass;
    }

}
