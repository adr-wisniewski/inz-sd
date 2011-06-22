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
import servicedesk.core.itil.change.dao.RfcImpactDao;
import servicedesk.core.itil.change.domain.RfcImpact;
import servicedesk.core.itil.change.validator.RfcImpactAddValidator;
import servicedesk.core.itil.change.validator.RfcImpactDeleteValidator;
import servicedesk.core.base.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional(readOnly=true)
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcImpactServiceImpl  implements RfcImpactService {

    @Autowired
    protected RfcImpactDao dao;
    
    @Override
    public List<RfcImpact> getAll() {
        return dao.getAll();
    }

    @PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
    @Transactional(readOnly=false)
    @Validated(validator=RfcImpactAddValidator.class)
    @Override
    public void add(RfcImpact object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
    @Validated(validator=RfcImpactAddValidator.class)
    @Override
    public void update(RfcImpact object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_IMPACT_CRUD')")
    @Validated(validator=RfcImpactDeleteValidator.class)
    @Override
    public void delete(RfcImpact object) {
        dao.remove(object);
    }

    @Override
    public RfcImpact load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RfcImpact get(Integer id) {
        return dao.get(id);
    }

    @Override
    public RfcImpact getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public RfcImpact loadByName(String name) {
        return dao.loadByName(name);
    }
    
}
