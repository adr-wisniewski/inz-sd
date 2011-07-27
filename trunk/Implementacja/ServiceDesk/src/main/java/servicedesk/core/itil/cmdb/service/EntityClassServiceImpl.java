/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.core.itil.cmdb.dao.EntityClassDao;
import servicedesk.core.itil.cmdb.domain.EntityClass;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class EntityClassServiceImpl implements EntityClassService {

    @Autowired
    protected EntityClassDao dao;

    @Override
    public EntityClass load(Integer id) {
       return dao.load(id);
    }

    @Override
    public EntityClass get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<EntityClass> getAll() {
        return dao.getAll();
    }
}
