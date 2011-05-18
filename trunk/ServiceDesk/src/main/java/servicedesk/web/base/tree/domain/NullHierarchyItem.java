/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.web.base.tree.domain;

import java.util.ArrayList;
import java.util.List;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
public class NullHierarchyItem implements HierarchicalDomainObject<String> {

    static final public NullHierarchyItem INSTANCE = new NullHierarchyItem();
    
    private NullHierarchyItem() {
        // do nothing
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public NullHierarchyItem getParent() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<NullHierarchyItem> getChildren() {
        return new ArrayList<NullHierarchyItem>(0);
    }
}
