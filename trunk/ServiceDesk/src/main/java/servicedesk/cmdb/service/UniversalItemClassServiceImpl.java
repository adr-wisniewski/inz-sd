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
import org.springframework.validation.BindingResult;
import servicedesk.cmdb.dao.UniversalItemClassDao;
import servicedesk.cmdb.domain.UniversalItemClass;
import servicedesk.cmdb.domain.helper.ItemClassCriteria;
import servicedesk.cmdb.validator.UniversalItemClassAddValidator;
import servicedesk.cmdb.validator.UniversalItemClassDeleteValidator;
import servicedesk.cmdb.validator.UniversalItemClassUpdateValidator;
import servicedesk.infrastructure.general.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_ITEMCLASS_VIEW')")
public class UniversalItemClassServiceImpl implements UniversalItemClassService {

    @Autowired
    protected UniversalItemClassDao dao;

    @Override
    public UniversalItemClass load(Integer id) {
        return dao.load(id);
    }

    @Override
    public UniversalItemClass get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<UniversalItemClass> getAll() {
        return dao.getAll();
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEMCLASS_ADD')")
    @Validated(validator=UniversalItemClassAddValidator.class)
    public void add(UniversalItemClass object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEMCLASS_EDIT')")
    @Validated(validator=UniversalItemClassUpdateValidator.class)
    public void update(UniversalItemClass object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ITEMCLASS_DELETE')")
    @Validated(validator=UniversalItemClassDeleteValidator.class, name="itemClass")
    public void delete(UniversalItemClass object) {
        dao.remove(object);
    }

    @Override
    public List<UniversalItemClass> search(ItemClassCriteria criteria) {
        return dao.searchByCriteria(criteria);
    }

    @Override
    public UniversalItemClass getByName(String name) {
        return dao.getByName(name);
    }
    
    @Override
    public UniversalItemClass loadByName(String name) {
        return dao.loadByName(name);
    }
}
