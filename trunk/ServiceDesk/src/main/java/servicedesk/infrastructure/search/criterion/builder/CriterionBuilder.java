/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion.builder;

import servicedesk.infrastructure.search.criterion.Criterion;

/**
 *
 * @author Adrian
 */
public interface CriterionBuilder {
    public Criterion build(String name, Object value);
    public boolean supports(Class<?> clazz);
}
