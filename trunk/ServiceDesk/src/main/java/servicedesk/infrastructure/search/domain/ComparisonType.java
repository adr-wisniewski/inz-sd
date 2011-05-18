/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

/**
 *
 * @author Adrian
 */
public enum ComparisonType {
    /**
     * 
     */
    LESS { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitLess(this, context);
        }
                
    },
    LESS_EQUAL { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitLessEqual(this, context);
        }
                
    },
    EQUAL { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitEqual(this, context);
        }
                
    },
    GREATER { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitGreater(this, context);
        }
                
    },
    GREATER_EQUAL { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitGreaterEqual(this, context);
        }
                
    },
    /**
     * 
     */
    NOT_EQUAL { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitNotEqual(this, context);
        }
                
    },
    /**
     * 
     */
    LIKE { 
        @Override
        public <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context) {
            return visitor.visitLike(this, context);
        }
                
    };
    
    /**
     * 
     * @param <T>
     * @param <C>
     * @param visitor
     * @param context
     * @return
     */
    public abstract <T,C> T accept(ComparisonTypeVisitor<T,C> visitor, C context);
}
