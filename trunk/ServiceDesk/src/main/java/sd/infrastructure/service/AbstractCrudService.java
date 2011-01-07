/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import sd.infrastructure.dao.CrudDao;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public abstract class AbstractCrudService<Type extends DomainObject<Id>, Id extends Serializable> implements CrudService<DomainObject<Id>, Id> {

    @Autowired
    protected CrudDao<Type, Id> crudDao;

    @Override
    public DomainObject<Id> load(Id id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DomainObject<Id> get(Id id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(DomainObject<Id> object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(DomainObject<Id> object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(DomainObject<Id> object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
