/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.extensions.hibernate.search;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.search.domain.ComparisonType;
import servicedesk.infrastructure.search.domain.ComparisonTypeVisitor;
import servicedesk.infrastructure.search.domain.SimpleCriterion;
import servicedesk.infrastructure.search.domain.Query;
import servicedesk.infrastructure.search.domain.QueryVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class DetachedCriteriaBuilder 
    implements QueryVisitor<DetachedCriteria>, 
        ComparisonTypeVisitor<Criterion, DetachedCriteriaBuilderTypeContext> {

    protected DetachedCriteria detachedCriteria;

    public DetachedCriteria build(Query<?> query) {
        detachedCriteria = DetachedCriteria.forClass(query.getTypeClass());
        query.accept(this, detachedCriteria);
        return detachedCriteria;
    }

    @Override
    public void visit(SimpleCriterion criterion, DetachedCriteria detachedCriteria) {
        DetachedCriteriaBuilderTypeContext context = new DetachedCriteriaBuilderTypeContext();
        context.setName(criterion.getName());
        context.setValue(criterion.getValue());
        detachedCriteria.add(criterion.getType().accept(this, context));
    }

    @Override
    public Criterion visitLess(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.lt(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitLessEqual(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.le(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitEqual(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.eq(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitGreater(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.gt(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitGreaterEqual(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.ge(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitNotEqual(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.ne(context.getName(), context.getValue());
    }

    @Override
    public Criterion visitLike(ComparisonType type, DetachedCriteriaBuilderTypeContext context) {
        return Restrictions.like(context.getName(), context.getValue());
    }

   
}
