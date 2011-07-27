/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.interfaces.domain;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public interface VersionedDomainObject<Id extends Serializable> extends DomainObject<Id> {
    public Integer getVersion();
}
