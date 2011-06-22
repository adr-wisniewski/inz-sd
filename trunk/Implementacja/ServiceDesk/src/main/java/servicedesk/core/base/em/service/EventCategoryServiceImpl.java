/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.em.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.base.em.dao.EventCategoryDao;
import servicedesk.core.base.em.domain.EventCategory;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.domain.IncidentCategory;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class EventCategoryServiceImpl implements  EventCategoryService {

    @Autowired
    protected EventCategoryDao dao;
    
    @Override
    public List<EventCategory> getAll() {
        return dao.getAll();
    }

    @Override
    public EventCategory load(String id) {
        return dao.load(id);
    }

    @Override
    public EventCategory get(String id) {
        return dao.get(id);
    }
    
}
