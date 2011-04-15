/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Repository
public class ItemClassDaoImpl implements ItemClassDao  {

    @Autowired
    private UniversalItemClassDao universalItemClassDao;

    @Autowired
    private AdaptorItemClassDao adaptorItemClassDao;

    @Override
    public ItemClass load(Integer id) {
        ItemClass itemClass = adaptorItemClassDao.get(id);
        
        if(itemClass == null) 
            itemClass = universalItemClassDao.load(id);
        
        return itemClass;
    }

    @Override
    public ItemClass get(Integer id) {
        ItemClass itemClass = adaptorItemClassDao.get(id);

        if(itemClass == null)
            itemClass = universalItemClassDao.get(id);

        return itemClass;
    }

    @Override
    public List<ItemClass> getAll() {
        List<ItemClass> all = new LinkedList<ItemClass>();
        all.addAll(universalItemClassDao.getAll());
        all.addAll(adaptorItemClassDao.getAll());
        return all;
    }

    @Override
    public ItemClass getByName(String name) {
        ItemClass itemClass = adaptorItemClassDao.getByName(name);

        if(itemClass == null)
            itemClass = universalItemClassDao.getByName(name);

        return itemClass;
    }

    @Override
    public ItemClass loadByName(String name) {
        ItemClass itemClass = adaptorItemClassDao.getByName(name);

        if(itemClass == null)
            itemClass = universalItemClassDao.loadByName(name);

        return itemClass;
    }

    @Override
    public Class<Integer> getIdClass() {
        return Integer.class;
    }
}
