/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import servicedesk.core.base.security.domain.User;
import servicedesk.core.base.security.service.AuthorizationService;
import servicedesk.core.itil.change.domain.RfcFactory;
import servicedesk.core.itil.change.domain.entity.Rfc;
import servicedesk.core.itil.change.domain.entity.RfcImpl;
import servicedesk.infrastructure.dao.hibernate.AbstractHibernateDao;

/**
 *
 * @author Adrian
 */
@Repository
public class RfcDaoImpl extends AbstractHibernateDao<Rfc, RfcImpl, Integer> implements RfcDao, RfcFactory {

    @Autowired
    protected AuthorizationService authorizationService;
    
    @Override
    public RfcImpl create() {
        User creator = authorizationService.getCurrentUser();
        return new RfcImpl(creator);
    }

}
