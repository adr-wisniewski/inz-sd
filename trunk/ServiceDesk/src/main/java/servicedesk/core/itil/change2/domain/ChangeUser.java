/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change2.domain;

import org.springframework.beans.factory.annotation.Autowired;
import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
public class ChangeUser  {
    private final User user;
    
    @Autowired
    protected RfcRepository rfcRepository;
    
    public ChangeUser(User user) {
        this.user = user;
    }
    
    public void submitRfc(Rfc rfc) {
        rfcRepository.add(rfc);
    }

    public Employee getEmployee() {
        return user.getEmployee();
    }

    public Rfc createRfc() {
        RfcImpl2 rfc = new RfcImpl2();
        rfc.setCreator(user.getEmployee());
        return rfc;
    }
}
