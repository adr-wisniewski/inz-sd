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
import sd.cmdb.dao.RelationshipClassDao;
import sd.cmdb.domain.RelationshipClass;
import sd.cmdb.domain.helper.RelationshipClassCriteria;
import sd.cmdb.validator.RelationshipClassAddValidator;
import sd.cmdb.validator.RelationshipClassDeleteValidator;
import sd.cmdb.validator.RelationshipClassUpdateValidator;
import sd.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CN_RLC_VIE')")
public class RelationshipClassServiceImpl implements RelationshipClassService {

    @Autowired
    protected RelationshipClassDao dao;

    @Override
    public RelationshipClass load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RelationshipClass get(Integer id) {
        return dao.get(id);
    }

    @Override
    @PreAuthorize("hasRole('CN_RLC_ADD')")
    @Validated(validator=RelationshipClassAddValidator.class)
    public void add(RelationshipClass object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_RLC_EDI')")
    @Validated(validator=RelationshipClassUpdateValidator.class)
    public void update(RelationshipClass object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_RLC_DEL')")
    @Validated(validator=RelationshipClassDeleteValidator.class)
    public void delete(RelationshipClass object) {
        dao.remove(object);
    }

    @Override
    public RelationshipClass getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public List<RelationshipClass> getAll() {
        return dao.getAll();
    }

    @Override
    public List<RelationshipClass> search(RelationshipClassCriteria criteria) {
        return dao.searchByCriteria(criteria);
    }

}
