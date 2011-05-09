/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.change.dao.RfcPriorityDao;
import servicedesk.change.domain.RfcPriority;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class RfcPriorityServiceImpl implements RfcPriorityService {

    @Autowired
    protected RfcPriorityDao dao;
    
    @Override
    public List<RfcPriority> getAll() {
        return dao.getAll();
    }
    
}
