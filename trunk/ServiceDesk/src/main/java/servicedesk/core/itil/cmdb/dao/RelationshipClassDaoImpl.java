/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import servicedesk.core.itil.cmdb.domain.EmployeeItemClass;
import servicedesk.core.itil.cmdb.domain.IncidentItemClass;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.ItemType;
import servicedesk.core.itil.cmdb.domain.ProblemItemClass;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.itil.cmdb.domain.RfcItemClass;
import servicedesk.core.itil.cmdb.domain.ServiceItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;
import servicedesk.core.itil.cmdb.domain.helper.RelationshipClassCriteria;

/**
 *
 * @author Adrian
 */
@Repository
public class RelationshipClassDaoImpl extends HibernateDaoSupport implements RelationshipClassDao {

    @Autowired protected EmployeeItemClass employeeItemClass;
    @Autowired protected IncidentItemClass incidentItemClass;
    @Autowired protected ProblemItemClass problemItemClass;
    @Autowired protected RfcItemClass rfcItemClass;
    @Autowired protected ServiceItemClass serviceItemClass;

    protected Map<ItemType, ItemClass> classMap = new EnumMap<ItemType, ItemClass>(ItemType.class);

    @PostConstruct
    protected void populateClassMap() {
        classMap.put(ItemType.EMP, employeeItemClass);
        classMap.put(ItemType.INC, incidentItemClass);
        classMap.put(ItemType.PRB, problemItemClass);
        classMap.put(ItemType.RFC, rfcItemClass);
        classMap.put(ItemType.SVC, serviceItemClass);
    }

    @Autowired
    public RelationshipClassDaoImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public List<RelationshipClass> getAll() {
        return postprocess(getHibernateTemplate().loadAll(RelationshipClass.class));
    }

    @Override
    public RelationshipClass get(Integer id) {
        return postprocess(getHibernateTemplate().get(RelationshipClass.class, id));
    }

    @Override
    public RelationshipClass load(Integer id) {
        return postprocess(getHibernateTemplate().load(RelationshipClass.class, id));
    }

    @Override
    public void persist(RelationshipClass object) {
        getHibernateTemplate().persist(object);
    }

    @Override
    public void remove(RelationshipClass object) {
        getHibernateTemplate().delete(object);
    }

    @Override
    public RelationshipClass merge(RelationshipClass object) {
        return postprocess(getHibernateTemplate().merge(object));
    }

    @Override
    public RelationshipClass getByName(String name) {
        @SuppressWarnings("unchecked")
        List<RelationshipClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findByName", "name", name);
        return postprocess(DataAccessUtils.singleResult(list));
    }
    
    @Override
    public RelationshipClass loadByName(String name) {
        @SuppressWarnings("unchecked")
        List<RelationshipClass> list = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findByName", "name", name);
        return postprocess(DataAccessUtils.requiredSingleResult(list));
    }

    @Override
    public List<RelationshipClass> searchByCriteria(final RelationshipClassCriteria searchcriteria) {
        if(!searchcriteria.isInitialized())
            return new ArrayList<RelationshipClass>();

        HibernateCallback<List<RelationshipClass>> callback = new HibernateCallback<List<RelationshipClass>>() {
            @Override
            @SuppressWarnings("unchecked")
            public List<RelationshipClass> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(RelationshipClass.class);
                initSearchCriteria(criteria, searchcriteria);
                return criteria.list();
            }
        };
    
        return postprocess(getHibernateTemplate().execute(callback));
    }


    protected void initSearchCriteria(Criteria hibernateCriteria, RelationshipClassCriteria searchCriteria) {

        if(searchCriteria.getId() != null)
            hibernateCriteria.add(Restrictions.eq("id", searchCriteria.getId()));

        if(StringUtils.hasText(searchCriteria.getParentName())) {
            hibernateCriteria.createAlias("parent", "p");
            hibernateCriteria.add(Restrictions.like("p.name", searchCriteria.getParentName()));
        }

        if(StringUtils.hasText(searchCriteria.getName()))
            hibernateCriteria.add(Restrictions.like("name", searchCriteria.getName()));

        if(StringUtils.hasText(searchCriteria.getDescription()))
            hibernateCriteria.add(Restrictions.like("description", searchCriteria.getDescription()));

        if(searchCriteria.getAbstraction() != null) {
            hibernateCriteria.add(Restrictions.eq("abstraction", searchCriteria.getAbstraction()));
        }
    }

    private List<RelationshipClass> postprocess(List<RelationshipClass> relationshipClasses) {
        for(RelationshipClass relationshipClass: relationshipClasses) {
            postprocess(relationshipClass);
        }

        return relationshipClasses;
    }

    private RelationshipClass postprocess(RelationshipClass relationshipClass) {
        if(relationshipClass != null) {
            ItemClass sourceItemClass = processItemClass(relationshipClass.getSourceType(), relationshipClass.getSourceUniversalItemClass());
            ItemClass targetItemClass = processItemClass(relationshipClass.getTargetType(), relationshipClass.getTargetUniversalItemClass());

            relationshipClass.setSourceItemClassDirect(sourceItemClass);
            relationshipClass.setTargetItemClassDirect(targetItemClass);
        }

        return relationshipClass;
    }

    private ItemClass processItemClass(ItemType itemType, UniversalItemClass universalItemClass) {
        ItemClass result = classMap.get(itemType);

        if(result == null) {
            result = universalItemClass;
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RelationshipClass> getAllForSourceClass(ItemClass itemClass) {
        List<RelationshipClass> result;
        GetForClassVisitor visitor = new GetForClassVisitor();
        itemClass.accept(visitor);

        if(visitor.getUniversalItemClass() != null) {
            List<UniversalItemClass> parentChain = visitor.getUniversalItemClass().getParentChain();
            result = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findForUniversalClass_source", "parentChain", parentChain);
        } else {
            result = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findForType_source", "type", visitor.getType());
        }

        return postprocess(result);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RelationshipClass> getAllForTargetClass(ItemClass itemClass) {
        List<RelationshipClass> result;
        GetForClassVisitor visitor = new GetForClassVisitor();
        itemClass.accept(visitor);

        if(visitor.getUniversalItemClass() != null) {
            List<UniversalItemClass> parentChain = visitor.getUniversalItemClass().getParentChain();
            result = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findForUniversalClass_target", "parentChain", parentChain);
        } else {
            result = getHibernateTemplate().findByNamedQueryAndNamedParam("RelationshipClass.findForType_target", "type", visitor.getType());
        }

        return postprocess(result);
    }
    
    protected static class GetForClassVisitor implements ItemClassVisitor {
        private ItemType type;
        private UniversalItemClass universalItemClass = null;

        public ItemType getType() {
            return type;
        }

        public UniversalItemClass getUniversalItemClass() {
            return universalItemClass;
        }

        @Override
        public void visit(UniversalItemClass universalItemClass) {
            type = ItemType.UNI;
            this.universalItemClass = universalItemClass;
        }

        @Override
        public void visit(EmployeeItemClass employeeItemClass) {
            type = ItemType.EMP;
        }

        @Override
        public void visit(IncidentItemClass incidentItemClass) {
            type = ItemType.INC;
        }

        @Override
        public void visit(ProblemItemClass problemItemClass) {
            type = ItemType.PRB;
        }

        @Override
        public void visit(RfcItemClass rfcItemClass) {
            type = ItemType.RFC;
        }

        @Override
        public void visit(ServiceItemClass serviceItemClass) {
            type = ItemType.SVC;
        }
    }
}
