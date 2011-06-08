/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.cmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.itil.cmdb.service.ItemClassService;
import servicedesk.core.itil.cmdb.service.RelationshipClassService;
import servicedesk.core.itil.cmdb.service.UniversalItemClassService;
import servicedesk.web.base.tree.TreeBuilder;

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
    public TreeBuilder<?> cmdbItemClassTree() {
        return new TreeBuilder<Integer>(Integer.class, itemClassService, null);
    }
    
    @Bean
    public TreeBuilder<?> cmdbUniversalItemClassTree() {
        return new TreeBuilder<Integer>(Integer.class, universalItemClassService, null);
    }
    
    @Bean
    public TreeBuilder<?> cmdbRelationshipClassTree() {
        return new TreeBuilder<Integer>(Integer.class, relationshipClassService, null);
    }
}
