/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.dao;

import sd.infrastructure.util.GenericUtil;
import java.io.Serializable;
import sd.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public class AbstractDao<Type extends DomainObject<Id>, Id extends Serializable> implements Dao<Type, Id> {

    protected Class<Type> typeClass = (Class<Type>)GenericUtil.getTypeArgument(AbstractDao.class, getClass(), 0);
    protected Class<Id> idClass = (Class<Id>)GenericUtil.getTypeArgument(AbstractDao.class, getClass(), 1);

    @Override
    public Class<Type> getTypeClass() {
        return typeClass;
    }

    @Override
    public Class<Id> getIdClass() {
        return idClass;
    }

}
