/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.common.attachment.dao.AttachmentDao;
import servicedesk.common.attachment.domain.Attachment;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
//@PreAuthorize("hasRole('COMMON_ATTACHMENT')")
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentDao dao;

    @Override
    public Attachment load(Integer id) {
        return dao.load(id);
    }
}
