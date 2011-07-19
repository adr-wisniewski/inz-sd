/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.service.ItemClassService;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.core.itil.cmdb.service.UniversalItemClassService;
import servicedesk.web.base.tree.TreeBuilder;
import servicedesk.web.base.tree.domain.TreeCustomizer;
import servicedesk.web.base.tree.domain.TreeItem;

/**
 *
 * @author Adrian
 */
@Configuration
public class CmdbTreeBuilderConfiguration {
    
    @Autowired
    protected ItemClassService itemClassService;
    
    @Autowired
    protected UniversalItemClassService universalItemClassService;
    
    @Autowired
    protected RelationshipClassService relationshipClassService;
           
    @Bean
    public TreeBuilder<?,?> cmdbItemClassTree() {
        return new TreeBuilder(Integer.class, itemClassService, null);
    }
    
    @Bean
    public TreeBuilder<?,?> browseCmdbItemsTree() {
        return new TreeBuilder(Integer.class, itemClassService, new TreeCustomizer<ItemClass>() {

            @Override
            public void customize(TreeItem item, ItemClass value) {
                if(value.isAbstraction())
                    item.setDisabled(true);  
            }  
        });
    }
    
    @Bean
    public TreeBuilder<?,?> cmdbUniversalItemClassTree() {
        return new TreeBuilder(Integer.class, universalItemClassService, null);
    }
    
    @Bean
    public TreeBuilder<?,?> cmdbRelationshipClassTree() {
        return new TreeBuilder(Integer.class, relationshipClassService, null);
    }
}
