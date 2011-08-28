/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import servicedesk.core.base.employee.domain.Employee;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcAuthority;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcAuthorityDaoImpl extends AbstractHibernateDao<RfcAuthority, RfcAuthority, Integer> implements RfcAuthorityDao {

    @Override
    public boolean isMember(RfcAuthority authority, Employee employee) {
        String[] params = {"rfcAuthorityId", "employeeId"};
        Object[] values = {authority.getId(), employee.getId()};
        
        List<Long> result = getHibernateTemplate().findByNamedQueryAndNamedParam("RfcAuthority.isMember", params, values);
        Long count = DataAccessUtils.requiredSingleResult(result);
        
        return count > 0;
    }

    @Override
    public List<RfcAuthority> getAllForRfc(Rfc rfc) {
        if(rfc.getCategory() == null)
            return new ArrayList<RfcAuthority>(0);
        
        List<RfcAuthority> result = getHibernateTemplate().findByNamedQueryAndNamedParam("RfcAuthority.getForCategory", "categoryId", rfc.getCategory().getId());
        return result;
    }

    @Override
    public List<RfcAuthority> getAllCabsForRfc(Rfc rfc) {
        if(rfc.getCategory() == null)
            return new ArrayList<RfcAuthority>(0);
        
        List<RfcAuthority> result = getHibernateTemplate().findByNamedQueryAndNamedParam("RfcAuthority.getCabsForCategory", "categoryId", rfc.getCategory().getId());
        return result;
    }

}
