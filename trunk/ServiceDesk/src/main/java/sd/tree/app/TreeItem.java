package sd.tree.app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import sd.tree.HierarchyItem;

public class TreeItem {
	private HierarchyItem value;
	
	private List<TreeItem> childs = new LinkedList<TreeItem>();
	
	private TreeItem parent;
	
	private boolean open = false;
	
	private boolean current = false;
	
	private boolean leaf = true;
	
	public TreeItem(HierarchyItem item) {
		this.value = item;
	}

	public String getName() {
		return value.getName();
	}
	
	public String getId() {
		return value.getId();
	}
	
	public HierarchyItem getValue() {
		return value;
	}

	public void setValue(HierarchyItem value) {
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
		return this.getValue().getId().equals(other.getValue().getParentId());
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
