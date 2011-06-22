/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.dao;

import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
public interface AttachDao {
    public void attach(DomainObject<?> object);
    public void detach(DomainObject<?> object);
}
