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
import servicedesk.core.itil.change.dao.RfcPriorityDao;
import servicedesk.core.itil.change.domain.RfcPriority;
import servicedesk.core.itil.change.validator.RfcPriorityAddValidator;
import servicedesk.core.itil.change.validator.RfcPriorityDeleteValidator;
import servicedesk.core.base.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcPriorityServiceImpl implements RfcPriorityService {

    @Autowired
    protected RfcPriorityDao dao;
    
    @Override
    @Validated(validator=RfcPriorityAddValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_PRIORITY_CRUD')")
    public void add(RfcPriority object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @Validated(validator=RfcPriorityAddValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_PRIORITY_CRUD')")
    public void update(RfcPriority object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @Validated(validator=RfcPriorityDeleteValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_PRIORITY_CRUD')")
    public void delete(RfcPriority object) {
        dao.remove(object);
    }

    @Override
    public RfcPriority load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RfcPriority get(Integer id) {
        return dao.get(id);
    }
    
    @Override
    public List<RfcPriority> getAll() {
        return dao.getAll();
    }

    @Override
    public RfcPriority getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public RfcPriority loadByName(String name) {
        return dao.loadByName(name);
    }
    
}
