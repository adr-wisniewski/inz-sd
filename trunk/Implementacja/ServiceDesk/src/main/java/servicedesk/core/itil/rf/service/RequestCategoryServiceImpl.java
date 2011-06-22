/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.rf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.itil.rf.dao.RequestCategoryDao;
import servicedesk.core.itil.rf.domain.RequestCategory;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class RequestCategoryServiceImpl implements  RequestCategoryService {

    @Autowired
    protected RequestCategoryDao dao;
    
    @Override
    public List<RequestCategory> getAll() {
        return dao.getAll();
    }

    @Override
    public RequestCategory load(String id) {
        return dao.load(id);
    }

    @Override
    public RequestCategory get(String id) {
        return dao.get(id);
    }
    
}
