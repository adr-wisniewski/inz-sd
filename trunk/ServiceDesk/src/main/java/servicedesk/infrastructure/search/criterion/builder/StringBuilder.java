/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion.builder;

import org.springframework.stereotype.Component;
import servicedesk.infrastructure.search.criterion.Criterion;
import servicedesk.infrastructure.search.criterion.CriterionOperation;
import servicedesk.infrastructure.search.criterion.SimpleCriterion;

/**
 *
 * @author Adrian
 */
@Component
public class StringBuilder extends AbstractCriterionBuilder<String> {

    @Override
    protected Criterion doBuild(String name, String value) {
        if(value.equals(""))
            return null;
        
        return new SimpleCriterion(name, CriterionOperation.LIKE, value);
    }
    
}
