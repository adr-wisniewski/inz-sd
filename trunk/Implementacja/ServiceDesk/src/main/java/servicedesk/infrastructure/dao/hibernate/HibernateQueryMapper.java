/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.dao.hibernate;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.search.criterion.CriterionVisitor;
import servicedesk.infrastructure.search.criterion.SimpleCriterion;
import servicedesk.infrastructure.search.criterion.CriterionOperationVisitor;
import servicedesk.infrastructure.search.criterion.Query;

/**
 *
 * @author Adrian
 */
@Component
public class HibernateQueryMapper 
    implements 
        CriterionVisitor<DetachedCriteria>,
        CriterionOperationVisitor<Criterion, SimpleCriterion> {
  
    public DetachedCriteria map(Query query) {
        DetachedCriteria result = DetachedCriteria.forClass(query.getType());
        query.accept(this, result);
        return result;
    }

    @Override
    public void visit(SimpleCriterion criterion, DetachedCriteria criteria) {
        criteria.add(criterion.getType().accept(this, criterion));
    }

    @Override
    public Criterion visitLess(SimpleCriterion context) {
        return Restrictions.lt(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitLessEqual(SimpleCriterion context) {
        return Restrictions.le(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitEqual(SimpleCriterion context) {
        return Restrictions.eq(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitGreaterEqual(SimpleCriterion context) {
        return Restrictions.ge(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitGreater(SimpleCriterion context) {
        return Restrictions.gt(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitNotEqual(SimpleCriterion context) {
        return Restrictions.ne(context.getPropertyName(), context.getValue());
    }

    @Override
    public Criterion visitLike(SimpleCriterion context) {
        return Restrictions.like(context.getPropertyName(), context.getValue());
    }
}
