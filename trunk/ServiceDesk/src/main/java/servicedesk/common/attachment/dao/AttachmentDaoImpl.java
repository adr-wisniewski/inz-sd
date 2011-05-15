/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.dao;

import org.springframework.stereotype.Repository;
import servicedesk.common.attachment.domain.Attachment;
import servicedesk.infrastructure.general.dao.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class AttachmentDaoImpl extends AbstractHibernateDao<Attachment, Integer> implements AttachmentDao {

}
