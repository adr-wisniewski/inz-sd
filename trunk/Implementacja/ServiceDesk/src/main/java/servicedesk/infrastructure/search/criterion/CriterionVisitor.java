/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

/**
 *
 * @param <C> 
 * @author Adrian
 */
public interface CriterionVisitor<C> {
    public void visit(SimpleCriterion criterion, C context);
}
