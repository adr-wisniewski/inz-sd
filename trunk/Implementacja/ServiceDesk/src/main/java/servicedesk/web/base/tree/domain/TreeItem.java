package servicedesk.web.base.tree.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

public class TreeItem {

    private HierarchicalDomainObject<?> value;
    private List<TreeItem> children = new LinkedList<TreeItem>();
    private TreeItem parent;
    private boolean open = false;
    private boolean selected = false;
    private boolean disabled = false;

    public TreeItem(HierarchicalDomainObject<?> item) {
        this.value = item;
    }
    
    public TreeItem(HierarchicalDomainObject<?> item, TreeItem parent) {
        this.value = item;
        setParent(parent);
    }

    //public String getName() {
    //	return value.getName();
    //}
    
    public HierarchicalDomainObject<?> getValue() {
        return value;
    }

    public void addChild(TreeItem child) {
        this.children.add(child);
        child.setParent(parent);
    }

    public List<TreeItem> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public TreeItem getParent() {
        return parent;
    }

    public final void setParent(TreeItem parent) {
        this.parent = parent;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
