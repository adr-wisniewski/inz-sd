/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import sd.cmdb.domain.ItemClass;

/**
 *
 * @author Adrian
 */
public interface ItemClassDeleteService {
    public void delete(Integer id);
    public ItemClass getItemClass();
}
