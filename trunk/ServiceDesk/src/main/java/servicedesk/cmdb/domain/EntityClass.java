/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import java.util.List;
import java.util.Set;
import servicedesk.cmdb.domain.helper.EntityClassVisitor;
import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;

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
