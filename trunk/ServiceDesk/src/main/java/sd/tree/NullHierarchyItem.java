/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.tree;

import java.io.Serializable;
import sd.infrastructure.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
public class NullHierarchyItem implements HierarchicalDomainObject<String> {

    static final public NullHierarchyItem INSTANCE = new NullHierarchyItem();
    
    private NullHierarchyItem()
    {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
        // do nothing
    }

    @Override
    public String getParentId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
