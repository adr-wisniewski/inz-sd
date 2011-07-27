/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.service;

import java.io.Serializable;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface CrudService<Type extends DomainObject<Id>, Id extends Serializable> extends EditService<Type, Id> {
    public Type create();
}
