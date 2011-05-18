/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

/**
 *
 * @param <ReturnType> 
 * @param <ContextType> 
 * @author Adrian
 */
public interface QueryVisitor<ContextType> {
    public void visit(SimpleCriterion criterion, ContextType context);
}
