/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

/**
 *
 * @param <R> 
 * @param <C> 
 * @author Adrian
 */
public interface CriterionOperationVisitor<R,C> {
    public R visitLess(C context);
    public R visitLessEqual(C context);
    public R visitEqual(C context);
    public R visitGreaterEqual(C context);
    public R visitGreater(C context);
    public R visitNotEqual(C context);
    public R visitLike(C context);
    
}
