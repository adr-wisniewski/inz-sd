/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.cmdb.dao.ItemClassDao;
import servicedesk.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_ITEMCLASS_VIEW')")
public class ItemClassServiceImpl implements ItemClassService {

    @Autowired
    protected ItemClassDao itemClassDao;

    @Override
    public List<ItemClass> getAll() {
        return itemClassDao.getAll();
    }

    @Override
    public ItemClass load(Integer id) {
        return itemClassDao.load(id);
    }
    
        @Override
    public ItemClass get(Integer id) {
        return itemClassDao.get(id);
    }

    @Override
    public ItemClass loadByName(String classname) {
        return itemClassDao.loadByName(classname);
    }

    @Override
    public ItemClass getByName(String name) {
        return itemClassDao.getByName(name);
    }

}
