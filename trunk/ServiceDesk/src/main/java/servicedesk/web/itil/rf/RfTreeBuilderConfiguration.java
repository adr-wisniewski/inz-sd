/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.rf;

import servicedesk.web.base.em.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.base.em.service.EventCategoryService;
import servicedesk.core.itil.rf.service.RequestCategoryService;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Configuration
public class RfTreeBuilderConfiguration {
    
    @Autowired
    protected RequestCategoryService categoryService;
           
    @Bean
    public TreeBuilder<?> rfCategoriesTree() {
        return new TreeBuilder<String>(String.class, categoryService, null);
    }
}
