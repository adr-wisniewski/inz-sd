/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.itil.cmdb.dao.ItemDao;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_ITEM_VIEW')")
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
    public Iterable<Item> getByClass(ItemClass itemClass) {
        return dao.getByClass(itemClass);
    }

    @Override
    public Iterable<Item> search(ItemCriteria criteria) {
        return dao.search(criteria);
    }

}
