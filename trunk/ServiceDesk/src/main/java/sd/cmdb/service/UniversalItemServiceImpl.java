/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import freemarker.template.utility.Collections12;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import sd.cmdb.dao.UniversalItemDao;
import sd.cmdb.domain.UniversalItem;
import sd.cmdb.validator.UniversalItemPreAddValidator;
import sd.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CN_ITM_VIE')")
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
    @PreAuthorize("hasRole('CN_ITM_ADD')")
    //@Validated(validator=UniversalItemPreAddValidator.class)
    public void add(UniversalItem object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITM_EDI')")
    //TODO: uncomment
    //@Validated(validator=ItemUpdateValidator.class)
    public void update(UniversalItem object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITM_DEL')")
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
