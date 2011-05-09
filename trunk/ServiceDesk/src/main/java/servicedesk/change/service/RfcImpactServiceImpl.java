/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.change.dao.RfcImpactDao;
import servicedesk.change.domain.RfcImpact;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class RfcImpactServiceImpl  implements RfcImpactService {

    @Autowired
    protected RfcImpactDao dao;
    
    @Override
    public List<RfcImpact> getAll() {
        return dao.getAll();
    }
    
}
