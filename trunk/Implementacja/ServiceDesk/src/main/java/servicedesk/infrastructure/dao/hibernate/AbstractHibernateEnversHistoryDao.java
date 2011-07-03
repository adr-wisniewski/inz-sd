/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.dao.hibernate;

import servicedesk.infrastructure.interfaces.dao.HistoryDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import servicedesk.core.base.history.domain.AuditRevisionEntity;
import servicedesk.infrastructure.interfaces.domain.DomainObject;
import servicedesk.core.base.history.domain.HistoryRecord;
import servicedesk.infrastructure.util.GenericUtil;

/**
 *
 * @author Adrian
 */
public abstract class AbstractHibernateEnversHistoryDao<AbstractType extends DomainObject<Id>, ConcreteType extends AbstractType, Id extends Serializable>
    extends HibernateDaoSupport
    implements HistoryDao<AbstractType, Id> {

    @SuppressWarnings("unchecked")
    private Class<ConcreteType> typeClass = (Class<ConcreteType>)GenericUtil.getTypeArgument(AbstractHibernateEnversHistoryDao.class, getClass(),1);
    
    @Autowired
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public List<HistoryRecord<AbstractType>> getChanges(final Id id) {
        
        HibernateCallback<List<HistoryRecord<AbstractType>>> callback = new HibernateCallback<List<HistoryRecord<AbstractType>>>() {
            @Override
            @SuppressWarnings("unchecked")
            public List<HistoryRecord<AbstractType>> doInHibernate(Session session) throws HibernateException, SQLException
            {
                AuditReader auditReader = AuditReaderFactory.get(session);
                AuditQuery query = auditReader.createQuery()
                    .forRevisionsOfEntity(typeClass, false, true)
                    .add(AuditEntity.id().eq(id))
                    .addOrder(AuditEntity.revisionNumber().asc());
                
                List resultList = query.getResultList();
                List<HistoryRecord<AbstractType>> result = new ArrayList<HistoryRecord<AbstractType>>(resultList.size());
               
                for(Object o : resultList) {
                    Object[] oa = (Object[])o;
  
                    HistoryRecord<AbstractType> record = new HistoryRecord<AbstractType>();

                    record.setObject((AbstractType)oa[0]);
                    record.setRevison((AuditRevisionEntity)oa[1]);
                    record.setRevisonType((RevisionType)oa[2]);
 
                    result.add(record);
                }
                
                return result;
            }

           
        };
        
        return getHibernateTemplate().execute(callback);
    }
}
