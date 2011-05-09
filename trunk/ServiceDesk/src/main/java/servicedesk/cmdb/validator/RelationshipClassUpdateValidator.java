/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.infrastructure.general.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipClassUpdateValidator extends AbstractValidator<RelationshipClass>{

    @Autowired
    protected RelationshipClassAddValidator relationshipClassAddValidator;

    @Override
    protected void doValidate(RelationshipClass target, Errors errors) {
        relationshipClassAddValidator.doValidate(target, errors);
        //TODO: implement
    }
}
