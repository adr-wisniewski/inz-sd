/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.interfaces.domain;

import java.util.Date;

/**
 *
 * @author Adrian
 */
public interface TimestampAutomaticallyMarked {
    public Date getTimestamp();
    public void setTimestamp(Date timestamp);
}
