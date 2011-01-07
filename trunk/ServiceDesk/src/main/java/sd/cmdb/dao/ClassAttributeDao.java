/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import org.springframework.dao.DataAccessException;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributePk;

/**
 *
 * @author Adrian
 */
public interface ClassAttributeDao {

    public void save(ClassAttribute classAttribute);
    public void update(ClassAttribute classAttribute);
    public void delete(ClassAttribute classAttribute);

    public ClassAttribute load(ClassAttributePk classAttributePk) throws DataAccessException;
}
