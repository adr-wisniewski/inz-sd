/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.List;
import java.util.Set;
import sd.cmdb.domain.helper.EntityClassVisitor;
import sd.infrastructure.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
public interface EntityClass extends HierarchicalDomainObject<Integer> {
    public boolean isAbstraction();

    public String getDescription();

    public EntityClass getParent();
    public Set<? extends EntityClass> getChildren();

    public List<Attribute> getAttributes();
    
    public List<Attribute> getInheritedAttributes();
    public List<Attribute> getAllAttributes();

    public void accept(EntityClassVisitor visitor);
}
