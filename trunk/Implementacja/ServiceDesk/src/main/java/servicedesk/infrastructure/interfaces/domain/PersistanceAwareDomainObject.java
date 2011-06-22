/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.domain;

import java.io.Serializable;

/**
 *
 * @param <Id> 
 * @author Adrian
 */
public interface PersistanceAwareDomainObject<Id extends Serializable> extends DomainObject<Id> {
    public void onPersist();
}
