/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.domain;

import servicedesk.domain.Employee;

/**
 * @author Adrian
 */
public interface CreatorMarked {
    public Employee getCreator();
    public void setCreator(Employee employee);
}
