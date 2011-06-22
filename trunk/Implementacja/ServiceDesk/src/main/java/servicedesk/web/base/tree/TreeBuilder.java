package servicedesk.web.base.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;
import servicedesk.infrastructure.interfaces.service.HierarchyService;
import servicedesk.web.base.tree.domain.NullHierarchyItem;
import servicedesk.web.base.tree.domain.TreeCustomizer;
import servicedesk.web.base.tree.domain.TreeItem;

public class TreeBuilder<Id extends Serializable> {

    private final HierarchyService<?, Id> dataSource;
    private final TreeCustomizer customizer;
    private Class<Id> idClass;

    public TreeBuilder(
            Class<Id> idClass,
            HierarchyService<?, Id> dataSource,
            TreeCustomizer customizer) {
        this.idClass = idClass;
        this.dataSource = dataSource;
        this.customizer = customizer;
    }

    public Class<Id> getIdClass() {
        return idClass;
    }

    public List<TreeItem> buildTree() {
        return buildTree(customizer, null); // start recursion
    }

    public List<TreeItem> buildTree(Id selected) {
        return buildTree(customizer, selected); // start recursion
    }

    /**
     * Tworzy hierarchie z listy elementow hierarchii
     * 
     * @param items lista elementow hierarchii
     * @param customizer 
     * @param selected obecna wartosc
     * @return lista korzeni
     */
    private List<TreeItem> buildTree(
            TreeCustomizer customizer,
            Id selected) {
        
        List<? extends HierarchicalDomainObject<?>> items = dataSource.getAll();
        List<TreeItem> roots = new LinkedList<TreeItem>();

        for (HierarchicalDomainObject<?> item : items) {
            // start from roots only
            if(item.getParent() != null)
                continue;
            
            TreeItem root = new TreeItem(item);
            buildTreeRecursive(root, customizer, selected);
            roots.add(root);
        }

        return roots;
    }

    private void buildTreeRecursive(TreeItem item, TreeCustomizer customizer, Id selected) {
        HierarchicalDomainObject<?> value = item.getValue();

        if (value.getId().equals(selected)) {
            item.setSelected(true);

            //ustaw otwarta sciezke do obecnie zaznaczonego elementu:
            for (TreeItem i = item.getParent(); i != null; i = i.getParent()) {
                i.setOpen(true);
            }
        }

        for (HierarchicalDomainObject<?> child : value.getChildren()) {
            TreeItem branch = new TreeItem(child);
            item.addChild(branch);

            buildTreeRecursive(branch, customizer, selected);
        }

        if (customizer != null) {
            customizer.customize(item);
        }
    }

    public HierarchicalDomainObject<?> getItem(Id itemId) {
        HierarchicalDomainObject<?> item = NullHierarchyItem.INSTANCE;

        if (itemId != null)
            item = dataSource.get(itemId);

        return item;
    }
}
