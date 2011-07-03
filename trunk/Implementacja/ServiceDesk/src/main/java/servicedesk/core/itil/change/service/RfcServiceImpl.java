/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.change.dao.RfcDao;
import servicedesk.core.itil.change.domain.entity.RfcChange;
import servicedesk.core.itil.change.domain.helper.NullRfc;
import servicedesk.core.itil.change.validator.RfcAddCommentValidator;
import servicedesk.core.itil.change.validator.RfcAddValidator;
import servicedesk.core.itil.change.validator.RfcDeleteValidator;
import servicedesk.core.itil.change.validator.RfcEditValidator;
import servicedesk.infrastructure.interfaces.dao.HistoryDao;
import servicedesk.core.base.history.domain.HistoryRecord;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.infrastructure.search.SearchObject;
import servicedesk.infrastructure.validation.Validated;
import servicedesk.core.itil.change.domain.RfcFactory;
import servicedesk.core.itil.change.domain.entity.Rfc;

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
    private RfcFactory factory;
    
    @Autowired
    protected NullRfc nullRfc;
    
    @Autowired
    protected AuthorizationService authorizationService;
    
    @Override
    public List<RfcChange> getChanges(Rfc rfc) {
        List<HistoryRecord<Rfc>> records = history.getChanges(rfc.getId());
        LinkedList<RfcChange> result = new LinkedList<RfcChange>();
        
        Rfc previous = nullRfc;
        for(HistoryRecord<Rfc> record: records) {

            RfcChange change = new RfcChange(record, previous);
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
    
    @Override
    public Rfc create() {
        return factory.create();
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
        original.setManager(authorizationService.getCurrentEmployeeUser().getEmployee());
    }

    @Override
    public List<Rfc> search(SearchObject<Rfc> criteria) {
        return dao.search(criteria);
    }
}
