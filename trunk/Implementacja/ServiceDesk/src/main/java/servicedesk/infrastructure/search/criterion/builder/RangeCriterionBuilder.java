/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion.builder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.search.Range;
import servicedesk.infrastructure.search.criterion.CompositeCriterion;
import servicedesk.infrastructure.search.criterion.Criterion;
import servicedesk.infrastructure.search.criterion.CriterionOperation;
import servicedesk.infrastructure.search.criterion.SimpleCriterion;

/**
 *
 * @author Adrian
 */
@Component
public class RangeCriterionBuilder extends AbstractCriterionBuilder<Range<?>> {

    @Override
    protected Criterion doBuild(String name, Range<?> value) {
        List<Criterion> criteria = new ArrayList<Criterion>(2);
        Object min = value.getMin();
        Object max = value.getMax();
        
        if(min != null) 
            criteria.add(new SimpleCriterion(name, CriterionOperation.GREATER_EQUAL, min));
        
        if(max != null) 
            criteria.add(new SimpleCriterion(name, CriterionOperation.LESS_EQUAL, max));
        
        if(criteria.isEmpty())
            return null;
        else if(criteria.size() == 1) 
            return criteria.get(0);
        else
            return new CompositeCriterion(criteria);
    }
}
