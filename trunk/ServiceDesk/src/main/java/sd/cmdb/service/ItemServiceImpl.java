/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.dao.ItemDao;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CN_ITM_VIE')")
public class ItemServiceImpl implements ItemService {

    @Autowired
    protected ItemDao dao;

    @Override
    public Item load(Integer id) {
        return dao.load(id);
    }

    @Override
    public Item get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Item> getByClass(ItemClass itemClass) {
        return dao.getByClass(itemClass);
    }

}
