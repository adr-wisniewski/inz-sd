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
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.cmdb.dao.RelationshipDao;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.core.itil.cmdb.validator.RelationshipAddValidator;
import servicedesk.core.itil.cmdb.validator.RelationshipDeleteValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_RELATIONSHIP_VIEW')")
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    protected RelationshipDao dao;

    @Override
    public Relationship load(Integer id) {
        return dao.load(id);
    }

    @Override
    public Relationship get(Integer id) {
        return dao.get(id);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_RELATIONSHIP_ADD')")
    @Validated(validator=RelationshipAddValidator.class)
    public void add(Relationship object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_RELATIONSHIP_EDIT')")
    @Validated(validator=RelationshipAddValidator.class)
    public void update(Relationship object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_RELATIONSHIP_DELETE')")
    @Validated(validator=RelationshipDeleteValidator.class)
    public void delete(Relationship object) {
        dao.remove(object);
    }

    @Override
    public Relationship getSame(Relationship target) {
        return dao.getSame(target);
    }

    @Override
    public List<Relationship> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Relationship> forItem(Item item) {
        return dao.forItem(item);
    }
}
