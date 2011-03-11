/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import sd.cmdb.domain.RelationshipClass;
import sd.infrastructure.validation.AbstractValidator;

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
