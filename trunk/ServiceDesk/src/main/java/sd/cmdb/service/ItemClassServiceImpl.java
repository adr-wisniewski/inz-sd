/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.cmdb.dao.ItemClassDao;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

/**
 *
 * @author Adrian
 */
@Service
public class ItemClassServiceImpl implements ItemClassService {

    @Autowired
    protected ItemClassDao dao;

    @Override
    public List<ItemClass> search(ItemClassCriteria criteria) {
        return dao.searchByCriteria(criteria);
    }

    @Override
    public ItemClass getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public List<ItemClass> getAll() {
        return dao.getAll();
    }
}
