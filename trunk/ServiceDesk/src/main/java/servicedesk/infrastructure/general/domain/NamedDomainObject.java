/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.domain;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public interface NamedDomainObject<Id extends Serializable> extends DomainObject<Id> {
    	/**
	 * 
	 * @return nazwa elementu
	 */
	public String getName();
}
