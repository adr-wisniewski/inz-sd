/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.cmdb.dao.EntityClassDao;
import servicedesk.cmdb.domain.AbstractEntityClass;

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
    public AbstractEntityClass load(Integer id) {
       return dao.load(id);
    }

    @Override
    public AbstractEntityClass get(Integer id) {
        return dao.get(id);
    }

    @Override
    public void add(AbstractEntityClass object, BindingResult bindingResult) {
        dao.persist(object);
    }

    @Override
    public void update(AbstractEntityClass object, BindingResult bindingResult) {
        dao.merge(object);
    }

    @Override
    public void delete(AbstractEntityClass object) {
        dao.remove(object);
    }

    @Override
    public List<AbstractEntityClass> getAll() {
        return dao.getAll();
    }

}
