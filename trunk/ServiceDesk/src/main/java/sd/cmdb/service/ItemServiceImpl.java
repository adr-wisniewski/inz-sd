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
import org.springframework.validation.BindingResult;
import sd.cmdb.dao.ItemDao;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.validator.ItemAddValidator;
import sd.infrastructure.validation.Validated;

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
    @PreAuthorize("hasRole('CN_ITM_ADD')")
    @Validated(validator=ItemAddValidator.class)
    public void add(Item object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITM_EDI')")
    //TODO: uncomment
    //@Validated(validator=ItemUpdateValidator.class)
    public void update(Item object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITM_DEL')")
    //TODO: uncomment
    //@Validated(validator=ItemDeleteValidator.class, name="item")
    public void delete(Item object) {
        dao.remove(object);
    }

    @Override
    public List<Item> getByClass(ItemClass itemClass) {
        return dao.getByClass(itemClass);
    }

}
