/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.pm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.domain.IncidentCategory;
import servicedesk.core.itil.pm.dao.ProblemCategoryDao;
import servicedesk.core.itil.pm.domain.ProblemCategory;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class ProblemCategoryServiceImpl implements  ProblemCategoryService {

    @Autowired
    protected ProblemCategoryDao dao;
    
    @Override
    public List<ProblemCategory> getAll() {
        return dao.getAll();
    }

    @Override
    public ProblemCategory load(String id) {
        return dao.load(id);
    }

    @Override
    public ProblemCategory get(String id) {
        return dao.get(id);
    }
    
}
