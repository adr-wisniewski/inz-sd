/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.itil.pm.service.ProblemCategoryService;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Configuration
public class PmTreeBuilderConfiguration {
    
    @Autowired
    protected ProblemCategoryService categoryService;
           
    @Bean
    public TreeBuilder<?,?> pmCategoriesTree() {
        return new TreeBuilder(String.class, categoryService, null);
    }
}
