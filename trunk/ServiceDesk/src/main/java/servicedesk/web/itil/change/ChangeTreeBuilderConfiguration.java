/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.itil.change.service.RfcCategoryService;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Configuration
public class ChangeTreeBuilderConfiguration {
    
    @Autowired
    protected RfcCategoryService categoryService;
           
    @Bean
    public TreeBuilder<?> rfcCategoriesTree() {
        return new TreeBuilder<Integer>(Integer.class, categoryService, null);
    }
}
