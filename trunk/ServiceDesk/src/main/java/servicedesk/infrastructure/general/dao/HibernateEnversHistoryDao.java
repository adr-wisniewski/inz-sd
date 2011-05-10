/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.dao;

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
import org.springframework.stereotype.Repository;
import servicedesk.infrastructure.general.domain.AuditRevisionEntity;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.general.domain.HistoryRecord;

/**
 *
 * @author Adrian
 */
@Repository
public class HibernateEnversHistoryDao
    extends HibernateDaoSupport
    implements HistoryDao {

    
    @Autowired
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public <Type extends DomainObject<Id>, Id extends Serializable>
            List<HistoryRecord<Type>> getChanges(final Class<Type> type, final Id id) {
        
        HibernateCallback<List<HistoryRecord<Type>>> callback = new HibernateCallback<List<HistoryRecord<Type>>>() {
            @Override
            public List<HistoryRecord<Type>> doInHibernate(Session session) throws HibernateException, SQLException
            {
                AuditReader auditReader = AuditReaderFactory.get(session);
                AuditQuery query = auditReader.createQuery()
                    .forRevisionsOfEntity(type, false, true)
                    .add(AuditEntity.id().eq(id))
                    .addOrder(AuditEntity.revisionNumber().desc());
                
                List resultList = query.getResultList();
                List<HistoryRecord<Type>> result = new ArrayList<HistoryRecord<Type>>(resultList.size());
               
                HistoryRecord<Type> younger = null;
                for(Object o : query.getResultList()) {
                    Object[] oa = (Object[])o;
  
                    HistoryRecord<Type> record = new HistoryRecord<Type>();

                    record.setObject((Type)oa[0]);
                    record.setRevison((AuditRevisionEntity)oa[1]);
                    record.setRevisonType((RevisionType)oa[2]);
                    
                    if(younger != null)
                        younger.setPrevious(record);
                    
                    result.add(record);
                    younger = record;
                }
                
                return result;
            }

           
        };
        
        return getHibernateTemplate().execute(callback);
    }
}
