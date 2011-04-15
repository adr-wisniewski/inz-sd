/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import freemarker.template.utility.Collections12;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.cmdb.dao.UniversalItemDao;
import servicedesk.cmdb.domain.UniversalItem;
import servicedesk.cmdb.validator.UniversalItemPreAddValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_ITEM_VIEW')")
public class UniversalItemServiceImpl implements UniversalItemService {

    @Autowired
    protected UniversalItemDao dao;

    @Override
    public UniversalItem load(Integer id) {
        return dao.load(id);
    }

    @Override
    public UniversalItem get(Integer id) {
        return dao.get(id);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEM_ADD')")
    //@Validated(validator=UniversalItemPreAddValidator.class)
    public void add(UniversalItem object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEM_EDIT')")
    //TODO: uncomment
    //@Validated(validator=ItemUpdateValidator.class)
    public void update(UniversalItem object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEM_DELETE')")
    //TODO: uncomment
    //@Validated(validator=ItemDeleteValidator.class, name="item")
    public void delete(UniversalItem object) {
        dao.remove(object);
    }

    @Override
    @Validated(validator=UniversalItemPreAddValidator.class)
    public void preAdd(UniversalItem item, BindingResult bindingResult) {
        item.getAttributeValues().clear();
        item.populateAttributeValues();
    }

}
