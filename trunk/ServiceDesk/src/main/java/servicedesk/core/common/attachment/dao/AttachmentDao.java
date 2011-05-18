/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.attachment.dao;

import servicedesk.core.common.attachment.domain.Attachment;

/**
 *
 * @author Adrian
 */
public interface AttachmentDao {
    public Attachment load(Integer Id);
}
