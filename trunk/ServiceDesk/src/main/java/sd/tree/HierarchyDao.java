package sd.tree;

import java.io.Serializable;
import java.util.List;

public interface HierarchyDao<T extends HierarchyItem> {
	public List<T> fetchAll();
	
	public T findById(Serializable id);
}
