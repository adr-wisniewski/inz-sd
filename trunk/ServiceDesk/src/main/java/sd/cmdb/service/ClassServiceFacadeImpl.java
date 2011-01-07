/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.dao.ClassAttributeDao;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributePk;
import sd.cmdb.domain.ElementClass;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class ClassServiceFacadeImpl implements ClassServiceFacade{

    @Autowired
    private ClassAttributeDao classAttributeDao;

    @Autowired
    private ItemClassService itemClassService;

    // METHODS
    @Override
    public void addItemClass(ItemClass itemClass) {
        itemClassService.add(itemClass);
    }

    @Override
    public void updateItemClass(ItemClass itemClass) {
        itemClassService.update(itemClass);
    }

    @Override
    public ItemClass deleteItemClass(Integer classId) {
        ItemClass itemClass = itemClassService.getItemClassById(classId);
        itemClassService.delete(itemClass)
        return itemClass;
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

    @Override
    public void addClassAttribute(ClassAttribute classAttribute) {
        classAttributeDao.save(classAttribute);
    }

    @Override
    public void updateClassAttribute(ClassAttribute classAttribute) {
        classAttributeDao.update(classAttribute);
    }

    @Override
    public void deleteClassAttribute(ClassAttribute classAttribute) {
        classAttributeDao.delete(classAttribute);
    }

    @Override
    public ElementClass loadElementClass(Integer classId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ItemClass loadItemClass(Integer classId) {
        return itemClassService.loadItemClass(classId);
    }

    @Override
    public ClassAttribute loadClassAttribute(ClassAttributePk classAttributePk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
