/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.domain;

/**
 *
 * @author Adrian
 */
public interface Ownable {
    public User getOwner();
}
