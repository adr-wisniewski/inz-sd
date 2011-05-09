/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.domain;

import java.util.Date;

/**
 *
 * @author Adrian
 */
public interface CreationTimeMarked {
    public Date getCreationTimestamp();
    public void setCreationTimestamp(Date timestamp);
}
