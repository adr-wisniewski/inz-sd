/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.service;

import servicedesk.common.attachment.domain.Attachment;

/**
 *
 * @author Adrian
 */
public interface AttachmentService {
    public Attachment load(Integer id);
}
