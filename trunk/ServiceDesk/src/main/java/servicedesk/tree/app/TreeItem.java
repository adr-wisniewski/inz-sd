package servicedesk.tree.app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import servicedesk.infrastructure.general.domain.HierarchicalDomainObject;

public class TreeItem {
	private HierarchicalDomainObject<?> value;
	
	private List<TreeItem> childs = new LinkedList<TreeItem>();
	
	private TreeItem parent;
	
	private boolean open = false;
	
	private boolean current = false;
	
	private boolean leaf = true;
	
	public TreeItem(HierarchicalDomainObject<?> item) {
		this.value = item;
	}

	public String getName() {
		return value.getName();
	}
	
	public String getId() {
		return String.valueOf(value.getId());
	}
	
	public HierarchicalDomainObject<?> getValue() {
		return value;
	}

	public void setValue(HierarchicalDomainObject<?> value) {
		this.value = value;
	}

	public void addChild(TreeItem child) {
		this.childs.add(child);
		child.setParent(this);
	}
	
	public List<TreeItem> getChilds() {
		return Collections.unmodifiableList(childs);
	}
	
	public boolean isParent(TreeItem other) {
            
            if(other.getValue().getParent() == null)
                return false;
            
            return this.getValue().getId().equals(other.getValue().getParent().getId());
	}

	public TreeItem getParent() {
		return parent;
	}

	public void setParent(TreeItem parent) {
		this.parent = parent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
}
