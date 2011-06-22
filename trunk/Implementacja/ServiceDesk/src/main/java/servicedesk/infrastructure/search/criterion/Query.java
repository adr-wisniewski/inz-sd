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
public class Query extends CompositeCriterion {
    private final Class<?> type;
    private final boolean allowEmptyQueries;
    
    public Query(Class<?> type, boolean allowEmptyQueries, Collection<Criterion> criteria) {
        super(criteria);
        this.type = type;
        this.allowEmptyQueries = allowEmptyQueries; 
    }

    /**
     * @return the allowEmptyQueries
     */
    public boolean isAllowEmptyQueries() {
        return allowEmptyQueries;
    }

    /**
     * @return the type
     */
    public Class<?> getType() {
        return type;
    }
}
