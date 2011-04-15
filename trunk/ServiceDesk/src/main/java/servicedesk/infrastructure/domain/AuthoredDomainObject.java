/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.domain;

import java.io.Serializable;
import servicedesk.domain.Employee;

/**
 * @author Adrian
 */
public interface AuthoredDomainObject<Id extends Serializable> extends DomainObject<Id> {
    //public Date getCreationDate();
    public Employee getAuthor();
}
