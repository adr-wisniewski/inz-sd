/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.domain;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public interface DomainObject<Id extends Serializable> {
    public Id getId();
}
