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
import servicedesk.change.dao.RfcDao;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.change.validator.RfcAddValidator;
import servicedesk.infrastructure.general.dao.HistoryDao;
import servicedesk.infrastructure.general.domain.HistoryRecord;
import servicedesk.infrastructure.general.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CHANGE_RFC_VIEW')")
public class RfcServiceImpl implements RfcService {

    @Autowired
    protected RfcDao dao;
    
    @Autowired
    private HistoryDao history;
    
    @Override
    public List<HistoryRecord<Rfc>> getChanges(Integer id) {
        return history.getChanges(Rfc.class, id);
    }
    
    @Override
    public Rfc load(Integer id) {
        return dao.load(id);
    }

    @Override
    public Rfc get(Integer id) {
        return dao.get(id);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_ADD')")
    @Validated(validator=RfcAddValidator.class)
    @Override
    public void add(Rfc object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_EDIT')")
    //TODO: @Validated(validator=RfcEditValidator.class)
    @Override
    public void update(Rfc object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_DELETE')")
    //TODO: @Validated(validator=RfcDeleteValidator.class)
    @Override
    public void delete(Rfc object) {
        dao.remove(object);
    }

    @Override
    public List<Rfc> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Rfc> search(RfcCriteria criteria) {
        return dao.search(criteria);
    }
}
