/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ItemClassDao itemClassDao;

    // METHODS
    @Override
    public void addItemClass(ItemClass itemClass) {
        itemClassDao.save(itemClass);
    }

    @Override
    public void updateItemClass(ItemClass itemClass) {
        itemClassDao.update(itemClass);
    }

    @Override
    public void deleteItemClass(ItemClass itemClass) {
        itemClassDao.delete(itemClass);
    }

    @Override
    public ItemClass getItemClassByName(String name) {
        return itemClassDao.getByName(name);
    }

    @Override
    public ItemClass getItemClassById(Integer identifier) {
        return itemClassDao.getById(identifier);
    }

    @Override
    public List<ItemClass> getAllItemClasses() {
        return itemClassDao.getAll();
    }

    @Override
    public List<ItemClass> searchItemClass(ItemClassCriteria criteria) {
        return itemClassDao.searchByCriteria(criteria);
    }
}
