/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.change.dao.RfcDao;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.RfcChange;
import servicedesk.change.domain.helper.NullRfc;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.change.validator.RfcAddCommentValidator;
import servicedesk.change.validator.RfcAddValidator;
import servicedesk.change.validator.RfcDeleteValidator;
import servicedesk.change.validator.RfcEditValidator;
import servicedesk.infrastructure.general.dao.HistoryDao;
import servicedesk.infrastructure.general.domain.HistoryRecord;
import servicedesk.infrastructure.general.spring.SpringSecurityUserDetailsService;
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
    
    @Autowired
    protected SpringSecurityUserDetailsService userService;
    
    @Override
    public List<RfcChange> getChanges(Rfc rfc) {
        List<HistoryRecord<Rfc>> records = history.getChanges(Rfc.class, rfc.getId());
        LinkedList<RfcChange> result = new LinkedList<RfcChange>();
        
        Rfc previous = NullRfc.INSTANCE;
        for(HistoryRecord<Rfc> record: records) {

            RfcChange change = new RfcChange();
            change.initialize(previous, record.getObject());
            change.setChangeType(record.getRevisonType());
            change.setInstigator(record.getRevison().getInstigator());
            change.setTimestamp(record.getRevison().getTimestamp());
            result.addFirst(change);
                  
            previous = record.getObject();
        }
        
        return result;
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
    @Validated(validator=RfcEditValidator.class)
    @Override
    public void update(Rfc object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @PreAuthorize("hasRole('CHANGE_RFC_DELETE')")
    @Validated(validator=RfcDeleteValidator.class)
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

    @Validated(validator=RfcAddCommentValidator.class)
    @Override
    public void addComment(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        original.setComment(rfc.getComment());
    }
    
    @PreAuthorize("hasRole('CHANGE_RFC_MANAGE')")
    @Override
    public void assignToSelf(Rfc rfc, BindingResult bindingResult) {
        Rfc original = load(rfc.getId());
        original.setManager(userService.getCurrentUser().getEmployee());
    }
}
