/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.cmdb.domain;

import servicedesk.infrastructure.interfaces.domain.DomainException;

/**
 *
 * @author Adrian
 */
public class EntityClassIsAbstractException extends DomainException {
    
    private EntityClass entityClass;
    
    EntityClassIsAbstractException(EntityClass entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * @return the entity
     */
    public EntityClass getEntityClass() {
        return entityClass;
    }
}
