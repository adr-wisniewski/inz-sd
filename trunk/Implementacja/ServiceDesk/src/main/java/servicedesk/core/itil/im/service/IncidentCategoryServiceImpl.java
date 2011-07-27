/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.im.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.domain.IncidentCategory;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class IncidentCategoryServiceImpl implements IncidentCategoryService {

    @Autowired
    protected IncidentCategoryDao dao;
    
    @Override
    public List<IncidentCategory> getAll() {
        return dao.getAll();
    }

    @Override
    public IncidentCategory load(String id) {
        return dao.load(id);
    }

    @Override
    public IncidentCategory get(String id) {
        return dao.get(id);
    }
}
