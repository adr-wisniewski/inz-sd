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
import sd.cmdb.dao.UniversalItemClassDao;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;
import sd.cmdb.validator.UniversalItemClassAddValidator;
import sd.cmdb.validator.UniversalItemClassDeleteValidator;
import sd.cmdb.validator.UniversalItemClassUpdateValidator;
import sd.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CN_ITC_VIE')")
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
    @PreAuthorize("hasRole('CN_ITC_ADD')")
    @Validated(validator=UniversalItemClassAddValidator.class)
    public void add(UniversalItemClass object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITC_EDI')")
    @Validated(validator=UniversalItemClassUpdateValidator.class)
    public void update(UniversalItemClass object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ITC_DEL')")
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
