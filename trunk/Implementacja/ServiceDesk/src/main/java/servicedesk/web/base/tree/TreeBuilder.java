package servicedesk.web.base.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;
import servicedesk.infrastructure.interfaces.service.HierarchyService;
import servicedesk.web.base.tree.domain.NullHierarchyItem;
import servicedesk.web.base.tree.domain.TreeCustomizer;
import servicedesk.web.base.tree.domain.TreeItem;

public class TreeBuilder<Type extends HierarchicalDomainObject<Id>, Id extends Serializable> {

    private final HierarchyService<Type, Id> dataSource;
    private final TreeCustomizer customizer;
    private Class<Id> idClass;

    public TreeBuilder(
            Class<Id> idClass,
            HierarchyService<Type, Id> dataSource,
            TreeCustomizer<Type> customizer) {
        this.idClass = idClass;
        this.dataSource = dataSource;
        this.customizer = customizer;
    }

    public Class<Id> getIdClass() {
        return idClass;
    }

    public List<TreeItem> buildTree() {
        return buildTree(null); // start recursion
    }

    /**
     * Tworzy hierarchie z listy elementow hierarchii
     * 
     * @param items lista elementow hierarchii
     * @param customizer 
     * @param selected obecna wartosc
     * @return lista korzeni
     */
    public List<TreeItem> buildTree(Id selected) {
        
        List<Type> items = dataSource.getAll();
        List<TreeItem> roots = new LinkedList<TreeItem>();

        for (Type item : items) {
            // start from roots only
            if(item.getParent() != null)
                continue;
            
            TreeItem root = new TreeItem(item);
            buildTreeRecursive(item, root, selected);
            roots.add(root);
        }

        return roots;
    }

    private void buildTreeRecursive(Type value, TreeItem node, Id selected) {
        if (value.getId().equals(selected)) {
            node.setSelected(true);

            //ustaw otwarta sciezke do obecnie zaznaczonego elementu:
            for (TreeItem i = node.getParent(); i != null; i = i.getParent()) {
                i.setOpen(true);
            }
        }

        for (HierarchicalDomainObject<?> child : value.getChildren()) {
            TreeItem branch = new TreeItem(child);
            node.addChild(branch);

            buildTreeRecursive((Type)child, branch, selected);
        }

        if (customizer != null) {
            customizer.customize(node, value);
        }
    }

    public HierarchicalDomainObject<?> getItem(Id itemId) {
        HierarchicalDomainObject<?> item = NullHierarchyItem.INSTANCE;

        if (itemId != null)
            item = dataSource.get(itemId);

        return item;
    }
}
