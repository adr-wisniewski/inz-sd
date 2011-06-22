/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

/**
 *
 * @author Adrian
 */
public enum CriterionOperation {
    LESS {
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitLess(context);
        }
    },
    LESS_EQUAL{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitLessEqual(context);
        }
    },
    EQUAL{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitEqual(context);
        }
    },
    GREATER_EQUAL{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitGreaterEqual(context);
        }
    },
    GREATER{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitGreater(context);
        }
    },
    NOT_EQUAL{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitNotEqual(context);
        }
    },
    LIKE{
        @Override
        public <R, C> R accept(CriterionOperationVisitor<R, C> visitor, C context) {
            return visitor.visitLike(context);
        }
    };
    
    public abstract <R,C> R accept(CriterionOperationVisitor<R,C> visitor, C context);
}
