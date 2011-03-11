/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sd.cmdb.domain.EmployeeItem;
import sd.cmdb.domain.EmployeeItemClass;
import sd.cmdb.domain.IncidentItem;
import sd.cmdb.domain.IncidentItemClass;
import sd.cmdb.domain.Item;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.ProblemItem;
import sd.cmdb.domain.ProblemItemClass;
import sd.cmdb.domain.RfcItem;
import sd.cmdb.domain.RfcItemClass;
import sd.cmdb.domain.ServiceItem;
import sd.cmdb.domain.ServiceItemClass;
import sd.cmdb.domain.UniversalItem;
import sd.cmdb.domain.UniversalItemClass;
import sd.cmdb.domain.helper.ItemClassVisitor;
import sd.cmdb.domain.helper.ItemVisitor;

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
    public List<Item> getByClass(ItemClass itemClass) {
        GetByClassVisitor getByClassVisitor = new GetByClassVisitor(itemClass);
        itemClass.accept(getByClassVisitor);
        return getByClassVisitor.getItems();
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

    protected Item postprocess(Item item) {
        GetPostprocessorVisitor getPostprocessorVisitor = new GetPostprocessorVisitor();
        item.accept(getPostprocessorVisitor);
        return item;
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
        public void visit(UniversalItemClass universalItemClass) {
           items = getHibernateTemplate().findByNamedQueryAndNamedParam(
               "UniversalItem.findByClass", "itemClass", itemClass
           );
        }

        @Override
        public void visit(EmployeeItemClass employeeItemClass) {
            List<EmployeeItem> all = getHibernateTemplate().loadAll(EmployeeItem.class);

            for(EmployeeItem item: all) {
                item.setItemClass(employeeItemClass);
            }

            items = (List)all;
        }

        @Override
        public void visit(IncidentItemClass incidentItemClass) {
            List<IncidentItem> all = getHibernateTemplate().loadAll(IncidentItem.class);

            for(IncidentItem item: all) {
                item.setItemClass(incidentItemClass);
            }

            items = (List)all;
        }

        @Override
        public void visit(ProblemItemClass problemItemClass) {
            items = (List)getHibernateTemplate().loadAll(ProblemItem.class);
        }

        @Override
        public void visit(RfcItemClass rfcItemClass) {
            items = (List)getHibernateTemplate().loadAll(RfcItem.class);
        }

        @Override
        public void visit(ServiceItemClass serviceItemClass) {
            items = (List)getHibernateTemplate().loadAll(ServiceItem.class);
        }
    }

    protected class GetPostprocessorVisitor implements ItemVisitor {

        @Override
        public void visit(UniversalItem universalItem) {
            // do nothing, already bound to class
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
