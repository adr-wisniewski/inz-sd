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
import servicedesk.cmdb.dao.RelationshipClassDao;
import servicedesk.cmdb.domain.ItemClass;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.domain.helper.RelationshipClassCriteria;
import servicedesk.cmdb.validator.RelationshipClassAddValidator;
import servicedesk.cmdb.validator.RelationshipClassDeleteValidator;
import servicedesk.cmdb.validator.RelationshipClassUpdateValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_VIEW')")
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
    @PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_ADD')")
    @Validated(validator=RelationshipClassAddValidator.class)
    public void add(RelationshipClass object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_EDIT')")
    @Validated(validator=RelationshipClassUpdateValidator.class)
    public void update(RelationshipClass object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_RELATIONSHIPCLASS_DELETE')")
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

    @Override
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass) {
        return dao.getAllForSourceClass(itemClass);
    }

    @Override
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass) {
        return dao.getAllForTargetClass(itemClass);
    }

}
