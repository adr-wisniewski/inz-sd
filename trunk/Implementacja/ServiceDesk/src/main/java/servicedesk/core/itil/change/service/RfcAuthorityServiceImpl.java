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
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.change.dao.RfcAuthorityDao;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.core.itil.change.validator.RfcAuthorityAddValidator;
import servicedesk.core.itil.change.validator.RfcAuthorityDeleteValidator;
import servicedesk.core.itil.change.validator.RfcAuthorityEditValidator;
import servicedesk.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class RfcAuthorityServiceImpl implements RfcAuthorityService {

    @Autowired
    protected RfcAuthorityDao dao;
    
    @Override
    public RfcAuthority create() {
        return new RfcAuthority();
    }

    @Override
    @Validated(validator=RfcAuthorityAddValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
    public void add(RfcAuthority object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    @Validated(validator=RfcAuthorityEditValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
    public void update(RfcAuthority object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    @Validated(validator=RfcAuthorityDeleteValidator.class)
    @PreAuthorize("hasRole('CHANGE_RFC_AUTHORITY_CRUD')")
    public void delete(RfcAuthority object) {
        dao.remove(object);
    }

    @Override
    public List<RfcAuthority> getAll() {
        return dao.getAll();
    }

    @Override
    public RfcAuthority load(Integer id) {
        return dao.load(id);
    }

    @Override
    public RfcAuthority get(Integer id) {
        return dao.get(id);
    }

    @Override
    public boolean isMember(RfcAuthority authority, Employee employee) {
        
        if(authority == null || employee == null)
            return false;
        
        return dao.isMember(authority, employee);
    }

    @Override
    public RfcAuthority getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public RfcAuthority loadByName(String name) {
        return dao.loadByName(name);
    }

    @Override
    public List<RfcAuthority> getAllForRfc(Rfc rfc) {
        return dao.getAllForRfc(rfc);
    }

    @Override
    public List<RfcAuthority> getAllCabsForRfc(Rfc rfc) {
        return dao.getAllCabsForRfc(rfc);
    }
}
