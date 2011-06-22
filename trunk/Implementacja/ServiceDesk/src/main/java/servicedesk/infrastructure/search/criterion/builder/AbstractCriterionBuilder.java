/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion.builder;

import servicedesk.infrastructure.search.criterion.Criterion;
import servicedesk.infrastructure.util.GenericUtil;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public abstract class AbstractCriterionBuilder<Type> implements CriterionBuilder {

    @SuppressWarnings("unchecked")
    private Class<Type> typeClass = (Class<Type>)GenericUtil
            .getTypeArgument(AbstractCriterionBuilder.class, getClass(), 0);
    
    @Override
    @SuppressWarnings("unchecked")
    public Criterion build(String name, Object value) {
        return doBuild(name, (Type)value);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return typeClass.isAssignableFrom(clazz);
    }

    protected abstract Criterion doBuild(String name, Type value);
}
