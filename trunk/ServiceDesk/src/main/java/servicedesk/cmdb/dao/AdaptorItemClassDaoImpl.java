/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
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
    public ItemClass load(Integer id) {
        ItemClass itemClass = get(id);
        
        if(itemClass == null)
            throw new DataRetrievalFailureException("Identifier not found: " + id);
        
        return itemClass;
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
