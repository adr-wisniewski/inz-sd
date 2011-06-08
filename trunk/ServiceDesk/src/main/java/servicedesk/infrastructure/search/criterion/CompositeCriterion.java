/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

import java.util.Collection;

/**
 *
 * @author Adrian
 */
public class CompositeCriterion implements Criterion {
    protected final Collection<Criterion> criteria;
    
    public CompositeCriterion(Collection<Criterion> criteria) {
        this.criteria = criteria;
    }
    
    public boolean isEmpty() {
        return criteria.isEmpty();
    }

    @Override
    public <C> void accept(CriterionVisitor<C> visitor, C context) {
        for(Criterion criterion: criteria)
            criterion.accept(visitor, context);
    }
}
