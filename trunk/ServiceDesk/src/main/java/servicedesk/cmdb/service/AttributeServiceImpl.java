/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import servicedesk.cmdb.dao.AttributeDao;
import servicedesk.cmdb.domain.Attribute;
import servicedesk.cmdb.validator.AttributeDeleteValidator;
import servicedesk.cmdb.validator.AttributeAddValidator;
import servicedesk.infrastructure.general.validation.Validated;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
@PreAuthorize("hasRole('CMDB_ATTRIBUTE_VIEW')")
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
    @PreAuthorize("hasRole('CMDB_ATTRIBUTE_ADD')")
    @Validated(validator=AttributeAddValidator.class)
    public void add(Attribute object, BindingResult bindingResult) {
        attributeDao.persist(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ATTRIBUTE_EDIT')")
    @Validated(validator=AttributeAddValidator.class)
    public void update(Attribute object, BindingResult bindingResult) {
        attributeDao.merge(object);
    }

    @Override
    @PreAuthorize("hasRole('CMDB_ATTRIBUTE_DELETE')")
    @Validated(validator=AttributeDeleteValidator.class, name="attribute")
    public void delete(Attribute object) {
        attributeDao.remove(object);
    }

    @Override
    public List<Attribute> getAll() {
        return attributeDao.getAll();
    }
}
