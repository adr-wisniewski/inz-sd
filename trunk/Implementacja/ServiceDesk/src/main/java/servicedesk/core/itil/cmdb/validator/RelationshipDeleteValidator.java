/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import servicedesk.core.itil.cmdb.domain.Relationship;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipDeleteValidator extends AbstractValidator<Relationship>{

    @Override
    protected void doValidate(Relationship target, Errors errors) {
        // TODO: implement
    }
}
