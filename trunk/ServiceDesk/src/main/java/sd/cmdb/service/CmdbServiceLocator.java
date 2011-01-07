/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

/**
 *
 * @author Adrian
 */
public interface CmdbServiceLocator {
    public ItemClassLoadService getGetItemClassService();
    public ItemClassAddService getItemClassAddService();
    public ItemClassUpdateService getItemClassUpdateService();
    public ItemClassDeleteService getDeleteItemClassService();
}
