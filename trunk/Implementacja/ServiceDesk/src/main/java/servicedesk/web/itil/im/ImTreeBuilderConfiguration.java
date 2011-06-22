/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.itil.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.editor.IncidentCategoryEditor;
import servicedesk.core.itil.im.service.IncidentCategoryService;
import servicedesk.web.base.tree.TreeBuilder;

/**
 *
 * @author Adrian
 */
@Configuration
public class ImTreeBuilderConfiguration {
    
    @Autowired
    protected IncidentCategoryService categoryService;
           
    @Bean
    public TreeBuilder<?> imCategoriesTree() {
        return new TreeBuilder<String>(String.class, categoryService, null);
    }
}
