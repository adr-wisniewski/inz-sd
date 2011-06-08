/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search;

import java.util.logging.Level;
import java.util.logging.Logger;
import servicedesk.infrastructure.search.criterion.builder.CriterionBuilder;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.search.annotations.AllowEmptySearch;
import servicedesk.infrastructure.search.criterion.Criterion;
import servicedesk.infrastructure.search.criterion.CriterionOperation;
import servicedesk.infrastructure.search.criterion.Query;
import servicedesk.infrastructure.search.criterion.SimpleCriterion;
import servicedesk.infrastructure.util.GenericUtil;

/**
 *
 * @author Adrian
 */
@Component
public class QueryFactory {
    
    private static String CLASS_PROPERTY = "class";
    
    @Autowired
    protected Collection<CriterionBuilder> builders;
    
    public Query getCriteria(SearchObject<?> searchObject) {
        List<Criterion> criteria = new ArrayList<Criterion>();
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(searchObject.getClass());

        // read all properties
        for (PropertyDescriptor pd : pds) {      
            Object value;
            
            // ignore getClass()
            if(pd.getName().equals(CLASS_PROPERTY))
                continue;
            
            // try to get value
            try {
                value = pd.getReadMethod().invoke(searchObject);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(QueryFactory.class.getName()).log(Level.WARNING, null, ex);
                throw new RuntimeException(ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(QueryFactory.class.getName()).log(Level.WARNING, null, ex);
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(QueryFactory.class.getName()).log(Level.WARNING, null, ex);
                throw new RuntimeException(ex);
            }
   
            // build criterion for this property
            if(value != null) {
                Criterion criterion = buildCriterion(pd, value);
                if(criterion != null)
                    criteria.add(criterion);
            }
        }

        // get class of queried entity and check for allowing empty queries
        Class<?> clazz = GenericUtil.getTypeArgument(SearchObject.class, searchObject.getClass(), 0);
        boolean allowEmpty = resolveAllowEmpty(searchObject);
        
        return new Query(clazz, allowEmpty, criteria);
    }

    private Criterion buildCriterion(PropertyDescriptor pd, Object value) {
        Class<?> type = pd.getPropertyType();
        
        for(CriterionBuilder builder: builders) 
            if(builder.supports(type))
                return builder.build(pd.getName(), value);
       
        // revert to defaul equal criterion
        return new SimpleCriterion(pd.getName(), CriterionOperation.EQUAL, value);
    }
    
    private boolean resolveAllowEmpty(SearchObject<?> searchObject) {
        AllowEmptySearch allowEmpty = searchObject.getClass().getAnnotation(AllowEmptySearch.class);
        return allowEmpty == null ? false : allowEmpty.value();
    }
}
