/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain.helper;

import java.util.Date;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.RfcCategory;
import servicedesk.change.domain.RfcImpact;
import servicedesk.change.domain.RfcPriority;
import servicedesk.change.domain.RfcState;
import servicedesk.domain.Employee;

/**
 *
 * @author Adrian
 */
public class NullRfc extends Rfc {
    public final static NullRfc INSTANCE = new NullRfc();
    private static final long serialVersionUID = 1L;
    
    private NullRfc() {
        category = null;
        comment = null;
        creator = null;
        description = null;
        id = null;
        impact = null;
        manager = null;
        priority = null;
        state = null;
        timestamp = null;
        title = null;
    }

    @Override
    public void setCategory(RfcCategory category) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setComment(String comment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCreator(Employee creator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setId(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setImpact(RfcImpact impact) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setManager(Employee manager) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPriority(RfcPriority priority) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setState(RfcState state) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTimestamp(Date timestamp) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException();
    }
}
