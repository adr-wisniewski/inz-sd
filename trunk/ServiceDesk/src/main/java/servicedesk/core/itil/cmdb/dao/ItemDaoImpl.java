/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import servicedesk.core.itil.cmdb.domain.EmployeeItem;
import servicedesk.core.itil.cmdb.domain.EmployeeItemClass;
import servicedesk.core.itil.cmdb.domain.IncidentItem;
import servicedesk.core.itil.cmdb.domain.IncidentItemClass;
import servicedesk.core.itil.cmdb.domain.Item;
import servicedesk.core.itil.cmdb.domain.ItemClass;
import servicedesk.core.itil.cmdb.domain.ProblemItem;
import servicedesk.core.itil.cmdb.domain.ProblemItemClass;
import servicedesk.core.itil.cmdb.domain.RfcItem;
import servicedesk.core.itil.cmdb.domain.RfcItemClass;
import servicedesk.core.itil.cmdb.domain.ServiceItem;
import servicedesk.core.itil.cmdb.domain.ServiceItemClass;
import servicedesk.core.itil.cmdb.domain.UniversalItem;
import servicedesk.core.itil.cmdb.domain.UniversalItemClass;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassUtils;
import servicedesk.core.itil.cmdb.domain.helper.ItemClassVisitor;
import servicedesk.core.itil.cmdb.domain.helper.ItemCriteria;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;

/**
 *
 * @author Adrian
 */
@Repository
public class ItemDaoImpl extends HibernateDaoSupport implements ItemDao {

    @Autowired
    protected EmployeeItemClass employeeItemClass;

    @Autowired
    protected IncidentItemClass incidentItemClass;

    @Autowired
    protected ProblemItemClass problemItemClass;

    @Autowired
    protected RfcItemClass rfcItemClass;

    @Autowired
    protected ServiceItemClass serviceItemClass;


    @Autowired
    public ItemDaoImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public Iterable<Item> getByClass(ItemClass itemClass) {
        GetByClassVisitor getByClassVisitor = new GetByClassVisitor(itemClass);
        itemClass.accept(getByClassVisitor);
        return postprocess(getByClassVisitor.getItems());
    }

    @Override
    public Item load(Integer id) {
        return postprocess(getHibernateTemplate().load(Item.class, id));
    }

    @Override
    public Item get(Integer id) {
        return postprocess(getHibernateTemplate().get(Item.class, id));
    }
    
    @Override
    public List<Item> getAll() {
        List<Item> result = getHibernateTemplate().loadAll(Item.class);
        postprocess(result);
        return result;
    }

    @Override
    public void persist(UniversalItem object) {
        getHibernateTemplate().persist(object);
    }

    @Override
    public void merge(UniversalItem object) {
        getHibernateTemplate().merge(object);
    }

    @Override
    public void remove(UniversalItem object) {
        getHibernateTemplate().delete(object);
    }

    protected Iterable<Item> postprocess(Iterable<Item> items) {
        for(Item item: items) {
            postprocess(item);
        }

        return items;
    }

    protected Item postprocess(Item item) {
        GetPostprocessorVisitor getPostprocessorVisitor = new GetPostprocessorVisitor();
        item.accept(getPostprocessorVisitor);
        return item;
    }

    @Override
    public Iterable<Item> search(final ItemCriteria itemCriteria) {
        if(!itemCriteria.isInitialized())
            return new ArrayList<Item>();

        HibernateCallback<Iterable<Item>> callback = new HibernateCallback<Iterable<Item>>() {
            @Override
            public Iterable<Item> doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Criteria criteria = session.createCriteria(Item.class);
                initSearchCriteria(criteria, itemCriteria);

                @SuppressWarnings("unchecked")
                Iterable<Item> result = postprocess(criteria.list());

                if(itemCriteria.getItemClass() != null) {
                    result = Iterables.filter(result, new Predicate<Item>() {
                        @Override public boolean apply(Item input) {
                            return EntityClassUtils.isSameOrSubclass(itemCriteria.getItemClass(), input.getItemClass());
                        }
                    });
                }

                return result;
            }
        };

        return getHibernateTemplate().execute(callback);
    }

    private void initSearchCriteria(Criteria criteria, ItemCriteria itemCriteria) {
        if(StringUtils.hasText(itemCriteria.getLabel()))
            criteria.add(Restrictions.like("label", itemCriteria.getLabel()));
    }

    protected class GetByClassVisitor implements ItemClassVisitor {

        private List<Item> items;
        private ItemClass itemClass;

        public List<Item> getItems() {
            return items;
        }

        public GetByClassVisitor(ItemClass itemClass) {
            this.itemClass = itemClass;
        }

        protected HibernateTemplate getHibernateTemplate() {
            return ItemDaoImpl.this.getHibernateTemplate();
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(UniversalItemClass universalItemClass) {
           items = getHibernateTemplate().findByNamedQueryAndNamedParam(
               "UniversalItem.findByClass", "itemClass", itemClass
           );
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(EmployeeItemClass employeeItemClass) {
            items = (List)getHibernateTemplate().loadAll(EmployeeItem.class);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(IncidentItemClass incidentItemClass) {
            items = (List)getHibernateTemplate().loadAll(IncidentItem.class);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(ProblemItemClass problemItemClass) {
            items = (List)getHibernateTemplate().loadAll(ProblemItem.class);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(RfcItemClass rfcItemClass) {
            items = (List)getHibernateTemplate().loadAll(RfcItem.class);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void visit(ServiceItemClass serviceItemClass) {
            items = (List)getHibernateTemplate().loadAll(ServiceItem.class);
        }
    }

    protected class GetPostprocessorVisitor implements ItemVisitor {

        @Override
        public void visit(UniversalItem universalItem) {
            // do nothing, already bound to class an attributes
        }

        @Override
        public void visit(ServiceItem serviceItem) {
            serviceItem.setItemClass(serviceItemClass);
        }

        @Override
        public void visit(RfcItem rfcItem) {
            rfcItem.setItemClass(rfcItemClass);
        }

        @Override
        public void visit(ProblemItem problemItem) {
            problemItem.setItemClass(problemItemClass);
        }

        @Override
        public void visit(IncidentItem incidentItem) {
            incidentItem.setItemClass(incidentItemClass);
        }

        @Override
        public void visit(EmployeeItem employeeItem) {
            employeeItem.setItemClass(employeeItemClass);
        }
    }
}
