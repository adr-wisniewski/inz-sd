/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

import java.util.ArrayList;
import java.util.Collection;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.general.util.GenericUtil;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public class AbstractQuery<Type extends DomainObject<?>> implements Query<Type> {

    @SuppressWarnings("unchecked")
    private Class<Type> clazz = (Class<Type>)GenericUtil.getTypeArgument(AbstractQuery.class, getClass(), 0);
    private Collection<Criterion> criteria = new ArrayList<Criterion>();
    private boolean criterialessAllowed;
    
    public void add(Criterion criterion) {
        criteria.add(criterion);
    }

    @Override
    public Class<Type> getTypeClass() {
        return clazz;
    }

    @Override
    public <C> void accept(QueryVisitor<C> visitor, C context) {
        for(Criterion c: criteria) {
            c.accept(visitor, context);
        }
    }

    @Override
    public void setCriterialessAllowed(boolean allowEmpty) {
        this.criterialessAllowed = allowEmpty;
    }

    @Override
    public boolean getCriterialessAllowed() {
        return criterialessAllowed;
    }

    @Override
    public boolean isEmpty() {
        return criteria.isEmpty() && !criterialessAllowed;
    }
    
}
