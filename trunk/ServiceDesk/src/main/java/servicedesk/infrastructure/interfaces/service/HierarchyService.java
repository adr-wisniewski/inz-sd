/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.service;

import java.io.Serializable;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/**
 *
 * @param <Type> 
 * @param <Id> 
 * @author Adrian
 */
public interface HierarchyService<Type extends HierarchicalDomainObject<Id>, Id extends Serializable> extends GetService<Type, Id> {
    
}
