/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change2.domain;

import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
public class ChangeManager {
    
    protected final User user;
    
    public ChangeManager(User user) {
        this.user = user;
    }

    public void assignRfcToSelf(Rfc rfc) {
        rfc.assignTo(this);
    }

    public Employee getEmployee() {
        return user.getEmployee();
    }
}
