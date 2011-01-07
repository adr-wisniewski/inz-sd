/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.domain;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public interface VersionedDomainObject<Id extends Serializable> extends DomainObject<Id> {
    public Integer getVersion();
}
