/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.cmdb.domain.RelationshipClass;
import servicedesk.core.base.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipClassDeleteValidator extends AbstractValidator<RelationshipClass>{

    @Autowired
    protected EntityClassDeleteValidator entityClassDeleteValidator;

    @Override
    protected void doValidate(RelationshipClass target, Errors errors) {
        entityClassDeleteValidator.doValidate(target, errors);
        // TODO: implement
    }
}
