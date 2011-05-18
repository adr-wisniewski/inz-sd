/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.interfaces.domain;

import servicedesk.core.hr.domain.Employee;

/**
 * @author Adrian
 */
public interface CreatorAutomaticallyMarked {
    public Employee getCreator();
    public void setCreator(Employee employee);
}
