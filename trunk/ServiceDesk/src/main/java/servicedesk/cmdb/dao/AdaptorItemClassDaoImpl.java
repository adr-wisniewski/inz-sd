/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import servicedesk.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
@Repository
public class AdaptorItemClassDaoImpl implements AdaptorItemClassDao {

    @Autowired
    protected List<ItemClass> itemClasses;

    protected List<ItemClass> getItemClasses() {
        return itemClasses;
    }

    @Override
    public ItemClass get(final Integer id) {

        for(ItemClass itemClass: getItemClasses()) {
            if(itemClass.getId().equals(id))
                return itemClass;
        }

        return null;
    }

    @Override
    public ItemClass getByName(final String name) {
       for(ItemClass itemClass: getItemClasses()) {
            if(itemClass.getName().equals(name))
                return itemClass;
        }

        return null;
    }

    @Override
    public List<ItemClass> getAll() {
        return getItemClasses();
    }
}
