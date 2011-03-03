/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import sd.cmdb.dao.AttributeDao;
import sd.cmdb.domain.Attribute;
import sd.cmdb.validator.AttributeDeleteValidator;
import sd.cmdb.validator.AttributeAddValidator;
import sd.infrastructure.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CN_ATR_VIE')")
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    protected AttributeDao attributeDao;

    @Override
    public Attribute load(Integer id) {
        return attributeDao.load(id);
    }

    @Override
    public Attribute get(Integer id) {
        return attributeDao.get(id);
    }

    @Override
    @PreAuthorize("hasRole('CN_ATR_ADD')")
    @Validated(validator=AttributeAddValidator.class)
    public void add(Attribute object, BindingResult bindingResult) {
        attributeDao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ATR_EDI')")
    @Validated(validator=AttributeAddValidator.class)
    public void update(Attribute object, BindingResult bindingResult) {
        attributeDao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CN_ATR_DEL')")
    @Validated(validator=AttributeDeleteValidator.class, name="attribute")
    public void delete(Attribute object) {
        attributeDao.remove(object);
    }

}
