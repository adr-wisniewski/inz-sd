/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import servicedesk.change.domain.Rfc;
import servicedesk.change.domain.helper.RfcCriteria;
import servicedesk.infrastructure.general.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcDaoImpl extends AbstractHibernateCrudDao<Rfc, Integer> implements RfcDao {


    @Override
    public List<Rfc> search(final RfcCriteria searchcriteria) {
        if(!searchcriteria.isInitialized())
            return new ArrayList<Rfc>(0);

        HibernateCallback<List<Rfc>> callback = new HibernateCallback<List<Rfc>>() {
            @Override
            public List<Rfc> doInHibernate(Session session) throws HibernateException, SQLException
            {
                Criteria criteria = session.createCriteria(Rfc.class);
                initSearchCriteria(criteria, searchcriteria);
                return criteria.list();
            }
        };
         
        return getHibernateTemplate().execute(callback);
    }


    protected void initSearchCriteria(Criteria hibernateCriteria, RfcCriteria searchCriteria) {

        if(searchCriteria.getId() != null)
            hibernateCriteria.add(Restrictions.eq("id", searchCriteria.getId()));

        if(searchCriteria.getCreationTimestampMax() != null)
            hibernateCriteria.add(Restrictions.le("creationTimestamp", searchCriteria.getCreationTimestampMax()));
        
        if(searchCriteria.getCreationTimestampMin() != null)
            hibernateCriteria.add(Restrictions.ge("creationTimestamp", searchCriteria.getCreationTimestampMin()));

        if(searchCriteria.getCreator() != null)
            hibernateCriteria.add(Restrictions.eq("creator", searchCriteria.getCreator()));

        if(StringUtils.hasText(searchCriteria.getDescription()))
            hibernateCriteria.add(Restrictions.like("description", searchCriteria.getDescription()));

        if(searchCriteria.getImpact() != null)
            hibernateCriteria.add(Restrictions.eq("impact", searchCriteria.getImpact()));
      
        if(searchCriteria.getManager() != null)
            hibernateCriteria.add(Restrictions.eq("manager", searchCriteria.getManager()));
       
        if(searchCriteria.getPriority() != null)
            hibernateCriteria.add(Restrictions.eq("priority", searchCriteria.getPriority()));
 
        if(searchCriteria.getState() != null)
            hibernateCriteria.add(Restrictions.eq("state", searchCriteria.getState()));

        if(searchCriteria.getTitle() != null)
            hibernateCriteria.add(Restrictions.like("title", searchCriteria.getTitle()));
    }
    
    
}
