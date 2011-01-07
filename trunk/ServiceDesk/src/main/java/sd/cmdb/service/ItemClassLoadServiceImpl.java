/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class ItemClassLoadServiceImpl implements ItemClassLoadService {

    @Autowired
    private ItemClassDao itemClassDao;
    
    @Override
    public ItemClass load(Integer classId) {
        return itemClassDao.load(classId);
    }

    @Override
    public ItemClass getByName(String name) {
        return itemClassDao.getByName(name);
    }

    @Override
    public ItemClass getById(Integer identifier) {
        return itemClassDao.getById(identifier);
    }

    @Override
    public List<ItemClass> getAll() {
        return itemClassDao.getAll();
    }

    @Override
    public List<ItemClass> search(ItemClassCriteria criteria) {
        return itemClassDao.searchByCriteria(criteria);
    }
}
