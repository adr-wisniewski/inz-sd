/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import servicedesk.change.domain.RfcCategory;
import servicedesk.infrastructure.general.dao.CrudDao;
import servicedesk.infrastructure.general.dao.HierarchyDao;
import servicedesk.infrastructure.general.dao.NamedDao;

/**
 *
 * @author Adrian
 */
public interface RfcCategoryDao 
    extends CrudDao<RfcCategory, Integer>, NamedDao<RfcCategory, Integer>, HierarchyDao<RfcCategory, Integer> {
    
}
