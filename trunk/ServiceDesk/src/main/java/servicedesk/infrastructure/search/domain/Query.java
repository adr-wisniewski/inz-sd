/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public interface Query<Type extends DomainObject<?>> {
    
    public void setCriterialessAllowed(boolean allowEmpty);
    public boolean getCriterialessAllowed();
    public boolean isEmpty();
    
    Class<Type> getTypeClass();
    public <C> void accept(QueryVisitor<C> visitor, C context);
}
