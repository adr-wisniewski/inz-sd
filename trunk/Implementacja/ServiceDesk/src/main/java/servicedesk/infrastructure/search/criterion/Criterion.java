/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

/**
 *
 * @author Adrian
 */
public interface Criterion {
    public <C> void accept(CriterionVisitor<C> visitor, C context);
}
