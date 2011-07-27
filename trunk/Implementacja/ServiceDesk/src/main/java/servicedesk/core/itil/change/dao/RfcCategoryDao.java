/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.infrastructure.interfaces.dao.CrudDao;
import servicedesk.infrastructure.interfaces.dao.HierarchyDao;
import servicedesk.infrastructure.interfaces.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcCategoryDao 
    extends CrudDao<RfcCategory, Integer>, NamedDao<RfcCategory, Integer>, HierarchyDao<RfcCategory, Integer> {
    
}
