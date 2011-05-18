/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.attachment.domain;

import java.util.Set;

/**
 *
 * @author Adrian
 */
public interface HasAttachments {
    public Set<Attachment> getAttachments();
}
