/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.tree;

/**
 *
 * @author Adrian
 */
public class NullHierarchyItem implements HierarchyItem {

    static final public NullHierarchyItem INSTANCE = new NullHierarchyItem();
    
    private NullHierarchyItem()
    {

    }

    @Override
    public String getId() {
        return null;
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
