/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.List;
import java.util.Set;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassVisitor;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
public interface EntityClass extends HierarchicalDomainObject<Integer> {
    public boolean isAbstraction();
    public String getDescription();

    @Override
    public EntityClass getParent();
    
    @Override
    public Set<? extends EntityClass> getChildren();

    public List<Attribute> getAttributes();
    
    public List<Attribute> getInheritedAttributes();
    public List<Attribute> getAllAttributes();
    public List<Attribute> getAllAttributesSorted();

    public void accept(EntityClassVisitor visitor);
}
