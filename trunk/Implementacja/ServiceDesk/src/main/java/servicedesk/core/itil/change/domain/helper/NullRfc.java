/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.helper;

import java.util.Date;
import org.springframework.stereotype.Component;
import servicedesk.core.itil.change.domain.entity.RfcCategory;
import servicedesk.core.itil.change.domain.entity.RfcImpact;
import servicedesk.core.itil.change.domain.entity.RfcPriority;
import servicedesk.core.itil.change.domain.entity.RfcResolution;
import servicedesk.core.itil.change.domain.entity.RfcState;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.itil.change.domain.entity.Rfc;

/**
 *
 * @author Adrian
 */
@Component
public class NullRfc implements Rfc {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getComment() {
        return null;
    }

    @Override
    public User getAuthor() {
        return null;
    }

    @Override
    public Date getTimestamp() {
        return null;
    }

    @Override
    public RfcState getState() {
        return null;
    }

    @Override
    public Employee getManager() {
        return null;
    }

    @Override
    public RfcPriority getPriority() {
        return null;
    }

    @Override
    public RfcImpact getImpact() {
        return null;
    }

    @Override
    public RfcCategory getCategory() {
        return null;
    }

    @Override
    public RfcResolution getResolution() {
        return null;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setComment(String comment) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setPriority(RfcPriority priority) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setImpact(RfcImpact impact) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setCategory(RfcCategory category) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setResolution(RfcResolution resolution) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setManager(Employee employee) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
