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
public interface ComparisonTypeVisitor<ReturnType, ContextType> {
    public ReturnType visitLess(ComparisonType type, ContextType context);
    public ReturnType visitLessEqual(ComparisonType type, ContextType context);
    public ReturnType visitEqual(ComparisonType type, ContextType context);
    public ReturnType visitGreater(ComparisonType type, ContextType context);
    public ReturnType visitGreaterEqual(ComparisonType type, ContextType context);
    public ReturnType visitNotEqual(ComparisonType type, ContextType context);
    public ReturnType visitLike(ComparisonType type, ContextType context);
}
