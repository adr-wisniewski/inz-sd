package sd.tree.app;

import java.util.LinkedList;
import java.util.List;

import sd.infrastructure.domain.HierarchicalDomainObject;

public abstract class TreeBuilder{
//	private static Logger logger = Logger.getLogger(TreeBuilder.class);
	/**
	 * Tworzy hierarchie z listy elementow hierarchii
	 * 
	 * @param items lista elementow hierarchii
	 * @param currentValue obecna wartosc
	 * @return lista korzeni
	 */
	@SuppressWarnings("unchecked")
	public static List<TreeItem> buildTree(List items, String currentValue) {
		List<TreeItem> roots = new LinkedList<TreeItem>();
		List<TreeItem> values = new LinkedList<TreeItem>();
		TreeItem current = null;
		
		//opakuj HierarchicalDomainObject w TreeItem:
		for(Object i : items) {
			if(i instanceof HierarchicalDomainObject) {
				HierarchicalDomainObject hierarchyItem = (HierarchicalDomainObject)i;
				TreeItem item = new TreeItem(hierarchyItem);
				if(hierarchyItem.getId().equals(currentValue)) {
					current = item;
					item.setCurrent(true);
				}
				values.add(item);
				roots.add(item);
			}
		}
		
		//ustaw dzieci:
		for(TreeItem p : values) {
			for(TreeItem c : values) {
				if(p.isParent(c)) {
					p.addChild(c);
					p.setLeaf(false); //to na pewno nie jest lisc, bo ma dziecko
					roots.remove(c); //to na pewno nie jest korzen, bo jest dzieckiem
				}
			}
		}
		
		//ustaw otwarta sciezke do obecnie zaznaczonego elementu:
		if(current != null) {
			for(TreeItem i = current.getParent() ; i != null ; i = i.getParent()) {
				i.setOpen(true);
			}
		}
		
		return roots;
	}
	
}
