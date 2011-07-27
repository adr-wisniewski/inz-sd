/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.attachment.dao;

import org.springframework.stereotype.Repository;
import servicedesk.core.common.attachment.domain.Attachment;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class AttachmentDaoImpl extends AbstractHibernateDao<Attachment, Attachment, Integer> implements AttachmentDao {

}
