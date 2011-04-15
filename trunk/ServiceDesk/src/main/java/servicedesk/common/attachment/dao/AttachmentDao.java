/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.dao;

import servicedesk.common.attachment.domain.Attachment;

/**
 *
 * @author Adrian
 */
public interface AttachmentDao {
    public Attachment load(Integer Id);
}
