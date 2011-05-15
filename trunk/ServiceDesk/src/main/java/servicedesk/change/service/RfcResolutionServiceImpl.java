/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.change.dao.RfcImpactDao;
import servicedesk.change.dao.RfcResolutionDao;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcResolution;
import servicedesk.change.validator.RfcImpactAddValidator;
import servicedesk.change.validator.RfcImpactDeleteValidator;
import servicedesk.change.validator.RfcResolutionAddValidator;
import servicedesk.change.validator.RfcResolutionDeleteValidator;
import servicedesk.infrastructure.general.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcResolutionServiceImpl  implements RfcResolutionService {

    @Autowired
    protected RfcResolutionDao dao;
    
    @Override
    public List<RfcResolution> getAll() {
        return dao.getAll();
    }

    @PreAuthorize("hasRole('CHANGE_RFC_RESOLUTION_CRUD')")
    @Validated(validator=RfcResolutionAddValidator.class)
    @Override
    public void add(RfcResolution object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_RESOLUTION_CRUD')")
    @Validated(validator=RfcResolutionAddValidator.class)
    @Override
    public void update(RfcResolution object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_RESOLUTION_CRUD')")
    @Validated(validator=RfcResolutionDeleteValidator.class)
    @Override
    public void delete(RfcResolution object) {
        dao.remove(object);
    }

    @Override
    public RfcResolution load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RfcResolution get(Integer id) {
        return dao.get(id);
    }

    @Override
    public RfcResolution getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public RfcResolution loadByName(String name) {
        return dao.loadByName(name);
    }
    
}
