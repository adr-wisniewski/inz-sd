/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.dao;

import java.util.List;
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
import sd.infrastructure.dao.AbstractHibernateCrudDao;

/**
 *
 * @author Adrian
 */
@Repository
public class ItemDaoImpl extends AbstractHibernateCrudDao<Item, Integer> implements ItemDao {

    @Override
    public List<Item> getByClass(ItemClass itemClass) {
        Class<? extends Item> clazz = GetByClassVisitor.process(itemClass);
        
        if(clazz == UniversalItem.class) {
           return getHibernateTemplate().findByNamedQueryAndNamedParam(
               "UniversalItem.findByClass", "itemClass", itemClass
           );
        }
        else {
            return (List)getHibernateTemplate().loadAll(clazz);
        }
    }

    protected static class GetByClassVisitor implements ItemClassVisitor {

        public static Class<? extends Item> process(ItemClass itemClass) {
            GetByClassVisitor getByClassVisitor = new GetByClassVisitor();
            itemClass.accept(getByClassVisitor);
            return getByClassVisitor.getClazz();
        }

        private Class<? extends Item> clazz;

        public Class<? extends Item> getClazz() {
            return clazz;
        }

        @Override
        public void visit(UniversalItemClass universalItemClass) {
            clazz = UniversalItem.class;
        }

        @Override
        public void visit(EmployeeItemClass employeeItemClass) {
            clazz = EmployeeItem.class;
        }

        @Override
        public void visit(IncidentItemClass incidentItemClass) {
            clazz = IncidentItem.class;
        }

        @Override
        public void visit(ProblemItemClass problemItemClass) {
            clazz = ProblemItem.class;
        }

        @Override
        public void visit(RfcItemClass rfcItemClass) {
            clazz = RfcItem.class;
        }

        @Override
        public void visit(ServiceItemClass serviceItemClass) {
            clazz = ServiceItem.class;
        }
    }

}
