/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.attachment.service;

import servicedesk.core.common.attachment.domain.Attachment;

/**
 *
 * @author Adrian
 */
public interface AttachmentService {
    public Attachment load(Integer id);
}
