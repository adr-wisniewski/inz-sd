/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.change.dao.RfcCategoryDao;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.core.itil.change.validator.RfcCategoryAddValidator;
import servicedesk.core.itil.change.validator.RfcCategoryDeleteValidator;
import servicedesk.core.itil.change.validator.RfcCategoryEditValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcCategoryServiceImpl implements RfcCategoryService {

    @Autowired
    protected RfcCategoryDao dao;
    
    @Override
    public RfcCategory load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RfcCategory get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<RfcCategory> getAll() {
        return dao.getAll();
    }

    @Override
    @Validated(validator=RfcCategoryAddValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_CATEGORY_CRUD')")
    public void add(RfcCategory object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @Validated(validator=RfcCategoryEditValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_CATEGORY_CRUD')")
    public void update(RfcCategory object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @Validated(validator=RfcCategoryDeleteValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_CATEGORY_CRUD')")
    public void delete(RfcCategory object) {
        dao.remove(object);
    }

    @Override
    public RfcCategory getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public RfcCategory loadByName(String name) {
        return dao.loadByName(name);
    }

    @Override
    public RfcCategory create() {
        return new RfcCategory();
    }
    
}
